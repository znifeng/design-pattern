package annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz){
		String strFruitName= "水果名称: ";
		String strFruitColor= "水果颜色: ";
		String strFruitProvider= "供应商信息: ";
		
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields){
			if (field.isAnnotationPresent(FruitName.class)){
				FruitName fruitName = (FruitName)field.getAnnotation(FruitName.class);
				strFruitName += fruitName.value();
				System.out.println(strFruitName);
			}
			
			if (field.isAnnotationPresent(FruitColor.class)){
				FruitColor fruitColor = (FruitColor)field.getAnnotation(FruitColor.class);
				strFruitColor += fruitColor.fruitColor().toString();
				System.out.println(strFruitColor);
			}
			
			if (field.isAnnotationPresent(FruitProvider.class)){
				FruitProvider fruitProvider = (FruitProvider)field.getAnnotation(FruitProvider.class);
				strFruitProvider += " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址：" + fruitProvider.address();
				System.out.println(strFruitProvider);
			}
		}
	}
}
