package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.form;

import lombok.Data;

@Data
public class CommentForm {

	private int userId, postId;
	private String text;
}
