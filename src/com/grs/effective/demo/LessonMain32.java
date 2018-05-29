package com.grs.effective.demo;

import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月12日 下午8:52:18
 */
public class LessonMain32 {

	@Test
	public void testMain32() {
		Text text = new Text();
		text.applyStyles(Text.STYLE_BOLD | Text.STYLE_ITALIC);
		NewText newText = new NewText();
		newText.applyStyles(EnumSet.of(TextStyle.BOLD, TextStyle.UNDERLINE));
	}

	// Int常量
	public class Text {
		public static final int STYLE_BOLD = 1 << 0;// 0
		public static final int STYLE_ITALIC = 1 << 1;// 2
		public static final int STYLE_UNDERLINE = 1 << 2;// 4

		public void applyStyles(int style) {
			LogUtil.i(style);// 1 + 2 = 3
			switch (style) {
			case STYLE_BOLD:
				LogUtil.i("style is bold");
				break;
			case STYLE_ITALIC:
				LogUtil.i("style is italic");
				break;
			case STYLE_UNDERLINE:
				LogUtil.i("style is underline");
				break;
			default:
				LogUtil.i("default");
				break;
			}
		}
	}

	// 枚举
	public enum TextStyle {
		BOLD, ITALIC, UNDERLINE;
	}

	public class NewText {
		public void applyStyles(Set<TextStyle> style) {
			for (TextStyle textStyle : style) {
				LogUtil.i(textStyle.name());
			}
		}
	}
}
