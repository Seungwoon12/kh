package com.example.demo.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	private static final Logger log =
			LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String uploadFile(String uploadPath, 
			String originalName, byte[] fileData) throws Exception {
		
		//UUID는 범용 고유 식별자
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		log.info("savedName: " + savedName);
		
		String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath + savedPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		
		String uploadedFileName = 
				savedPath.replace(File.separatorChar, '/') + '/' + savedName;
		
		/* Todo: Image 처리 */
		if (MediaUtils.getMediaType(formatName) != null) {
			makeThumbnail(uploadPath, savedPath, savedName);
		}
		
		return uploadedFileName;
	}
	
	public static void makeThumbnail(
			String uploadPath, String path, String fileName) throws Exception {
		
		BufferedImage sourceImg = 
				ImageIO.read(new File(uploadPath + path, fileName));
		
		BufferedImage destImg = 
				//원본 이미지의 비율을 유지하면서 높이를 100px로 하여 썸네일을 만들려면 아래와 같이 사용합니다.
				Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, 
						Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		String thumbnailName = 
				uploadPath + path + File.separator + "s_" + fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
	}

	public static String calcPath (String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		//File.separator는 OS에 따른 경로차이없이 경로를 설정하는 것. 즉 윈도우는 \
		//리눅스와 맥은 /이 파일 경로 구분자인데 이걸 알아서 설정해주는 것 인듯.
		//ex) String path = File.separator+"fileName"+File.separator+"sample.jpg";
		//위의 path는 /fileName/sample.jpg 또는 \fileName\sample.jpg가 된다.
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		
		//DecimalFormat 클래스는 new 연산자를 사용하여 객체를 생성한다. 지정할 수 있는 패턴 형식은 0과 #을 사용하여 지정한다.
		//'0'은 해당 자리수는 값이 최소한으로 있어야하고 '#'은 최대한 해당 소수점 자리수까지 (반올림하여) 보여준다.
		//ex) 78.53981633인 경우 '0.###'은 78.54(78.540이라 0은 출력되지 않는다.)
		//					   '000.##'은 078.54, '00.#'은 78.5
		String monthPath = yearPath + File.separator + 
				new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		
		String datePath = monthPath + File.separator +
				new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		log.info(datePath);
		
		return datePath;
	}
	
	//String... paths는 가변인자로 String타입의 매개변수를 원하는 만큼 입력가능. 컴파일러가
	//컴파일시 가변인자 매개변수를 배열로 만들어줌 > String[]
	private static void makeDir (String uploadPath, String... paths) {
		//최종 형식인 datePath 디렉토리가 이미 존재하면 메소드를 종료해라
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}
		
		for (String path: paths) {
			File dirPath = new File(uploadPath + path);
			
			if (!dirPath.exists()) {
				//mkdir()은 생성하려는 폴더의 위치에 가기전까지의 폴더가(폴더들이)존재해야만 새로 만들려고
				//하는 폴더를 생성가능. ex)C:\temp경로에 log라는 폴더를 생성하려고 할때 C드라이브에 temp라는
				//폴더가 존재하지 않으면 log디렉토리 생성에 실패함. 
				//이에 반해 mkdirs()는 temp가 없을시에 temp폴더를 생성하고 그 안에 log폴더를 생성해줌. 
				//즉, 지정한 경로에 폴더가 없는 경우에도 폴더를 생성하여 마지막으로 지정한 폴더까지 생성해준다.
				dirPath.mkdir(); 
			}
		}
	}
}