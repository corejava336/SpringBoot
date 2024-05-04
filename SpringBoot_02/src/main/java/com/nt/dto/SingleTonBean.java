package com.nt.dto;

import org.springframework.stereotype.Component;

@Component
public class SingleTonBean {
	private int count;

	public int getCount() {
		return count++;
	}
}