package cn.wulin.action;

import java.util.List;

import cn.wulin.base.ModelDrivenBaseAction;
import cn.wulin.domain.Address;

public class AddressAction extends ModelDrivenBaseAction<Address>{

	private static final long serialVersionUID = 1609800734590056149L;

	public String save() throws Exception {
		String[] addressArray = new String[]{"金牛区","锦江区","青羊区","成华区","武侯区","高新区","温江区","新都区","龙泉驿区"
				,"双流县","郫县","都江堰市","邛崃市","彭州市","崇州市","金堂县","大邑县","新津县","蒲江县"};
		
		Address parent = addressService.findEntity(53l);
		for (String sa : addressArray) {
			Address address = new Address();
			address.setName(sa);
			address.setParent(parent);
			addressService.saveEntity(address);
		}
		return null;
	}
	
	public String list() throws Exception{
		List<Address> addressList = addressService.findAll();
		for (Address address : addressList) {
			String name = null;
			if(address.getParent() != null){
				name = address.getParent().getName();
			}
			System.out.println(address.getName()+" : "+address.getId()+" : "+name);
		}
		return null;
	}

}
