package com.dev.sp.vo;

import com.dev.sp.enums.MessageType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ChatMessage {
	private int uiNum;
	private String uiName;
	private String text;
	private int roomId;
	private MessageType type;
}
