package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.form;

import lombok.Data;

@Data
public class PostMessageForm {
	private int userId;
	private String title, text, category;
}
