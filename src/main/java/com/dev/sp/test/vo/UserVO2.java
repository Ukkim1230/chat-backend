package com.dev.sp.test.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO2 {
	private int uiNum;
	@NotBlank(message = "아이디는 필수입니다.")
	@Size(min=4, max=30, message="아이디는 4글자 이상 30글자 이하입니다.")
    private String uiId;
	@NotBlank(message = "비밀번호는 필수입니다.")
	@Size(min=8, max=30, message="비밀번호는 8글자 이상 30글자 이하입니다.")
    private String uiPwd;
	@NotBlank(message = "이름은 필수입니다.")
    private String uiName;
    private String uiImgName;
    private String uiImgPath;
    @NotBlank(message = "주소는 필수입니다.")
    private String uiAddress1;
    private String uiAddress2;
    @NotBlank(message = "전화번호는 필수입니다.")
	@Pattern(regexp="^\\d{3}\\d{4}\\d{4}$", message = "올바른 전화번호 형식이 아닙니다.")
    private String uiPhone;
    private String uiDesc;
    private String creDat;
    private String creTim;
    private String lmoDat;
    private String lmoTim;
}
