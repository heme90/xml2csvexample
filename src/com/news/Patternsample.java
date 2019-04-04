package com.news;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patternsample {
	public static void main(String[] args) {
		Pattern pt = Pattern.compile("[\\/\\,\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\\\t\\\\n]");
		Matcher mt = pt.matcher("asdas1@!#!@%!%!@*(^&*(*{}{}[][}[]\n\n\t\t");
		System.out.println(mt.replaceAll(""));
	}
}
