package com.lepao.api.entity;


import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Dept  implements Serializable{ //必须实现接口,当然也可以交换json串
	private String deptno;
	private String dname;
	private String dbSource;
}
