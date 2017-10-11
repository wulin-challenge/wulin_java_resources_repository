package cn.wulin.util;

import java.util.Comparator;

import cn.wulin.domain.User;

/**
 * 这是一个用户比较器,要是用用户的年龄[age]进行排序
 * @author wulin
 *
 */
public class UserComparator implements Comparator<User>{

	public int compare(User o1, User o2) {
		Integer age1 = o1.getAge();
		Integer age2 = o2.getAge();
		if(age1 == null){
			age1 = Integer.MAX_VALUE;
		}
		if(age2 == null){
			age2 = Integer.MAX_VALUE;
		}
		//因为这里比较的是age1,所有市升序
		return age1.compareTo(age2);
	}
}
