package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import com.example.demo.util.MediaUtils;
import com.example.demo.util.UploadFileUtils;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	private static final Logger log =
			LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private ItemService itemService;
	
	@Value("${upload.path}")
	private String uploadPath;
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		List<Item> itemList = itemService.list();
		
		model.addAttribute("itemList", itemList);
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute(new Item());
		
		return "/item/register";
	}
	
	@PostMapping("/register")
	public String register(Item item, Model model) throws Exception {
		String[] files = item.getFiles();
		
		for(int i = 0; i < files.length; i++) {
			log.info("files[i] = " + files[i]);
		}
		
		itemService.regist(item);
		
		model.addAttribute("msg", "성공적으로 상품이 등록되었습니다.");
		
		return "item/success";
	}
	
	@PostMapping(value = "/uploadAjax", produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> uploadAjax (MultipartFile file) throws Exception {
		
		log.info("원본 파일명: " + file.getOriginalFilename());
		
		// 유틸 라이브러리 작성 필요
		String savedName = UploadFileUtils.uploadFile(
				uploadPath, file.getOriginalFilename(), file.getBytes());
		
		return new ResponseEntity<String>(savedName, HttpStatus.CREATED);
	}
	
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		log.info("파일명: " + fileName);
		
		try {
			String formatName = 
					fileName.substring(fileName.lastIndexOf(".") + 1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + fileName);
			
			if (mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\"" +
						new String(fileName.getBytes("UTF-8"), 
								"ISO-8859-1") + "\"");
			}
			
			entity = new ResponseEntity<byte[]>(
					IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	}
	
	@GetMapping("/modify")
	public String modifyForm(Integer itemId, Model model) throws Exception {
		
		Item item = itemService.read(itemId);
		
		model.addAttribute(item);
		
		return "item/modify";
	}
	
	@GetMapping("/getAttach/{itemId}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("itemId") Integer itemId) 
			throws Exception {
		
		return itemService.getAttach(itemId);
	}
	
	@PostMapping("/modify")
	public String modify(Item item, Model model) throws Exception {
		
		String[] files = item.getFiles();
		
		for (int i = 0; i < files.length; i++) {
			log.info("files[i] = " + files[i]);
		}
		
		itemService.modify(item);
		
		model.addAttribute("msg", "성공적으로 상품을 수정하였습니다.");
		
		return "item/success";
	}
	
	@GetMapping("/remove")
	public String removeForm(Integer itemId, Model model) throws Exception {
		Item item = itemService.read(itemId);
		
		model.addAttribute(item);
		
		return "item/remove";
	}
	
	@PostMapping("/remove")
	public String remove(Item item, Model model) throws Exception {
		itemService.remove(item.getItemId());
		
		model.addAttribute("msg", "상품 삭제가 성공적으로 완료되었습니다.");
		
		return "item/success";
	}
}