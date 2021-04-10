alter table item_attach add constraint fk_item_attach
foreign key (item_id) references async_image_item(item_id);