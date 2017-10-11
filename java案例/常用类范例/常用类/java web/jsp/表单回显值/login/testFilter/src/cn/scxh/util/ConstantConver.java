package cn.scxh.util;

public class ConstantConver {
	public static String getHobby(String hobby){
		String s = hobby.replaceAll("00", "ÀºÇò").replaceAll("01", "×ãÇò").replaceAll("02", "Æ¹ÅÒÇò")
		             .replaceAll("03", "¸ß¶û·ò").replaceAll("\\[", "").replaceAll("\\]", "");
		return s;
	}

}
