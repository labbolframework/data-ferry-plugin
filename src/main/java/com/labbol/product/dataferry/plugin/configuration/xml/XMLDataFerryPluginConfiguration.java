package com.labbol.product.dataferry.plugin.configuration.xml;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import com.labbol.product.dataferry.core.data.operate.DataObjectSourceOperator;
import com.labbol.product.dataferry.core.ferry.DataFerry;
import com.labbol.product.dataferry.core.ferry.impl.DefaultDataFerry;
import com.labbol.product.dataferry.core.resolve.DataFileResolver;
import com.labbol.product.dataferry.plugin.ferry.DataFerryTool;
import com.labbol.product.dataferry.plugin.ferry.xml.DefaultXMLDataFerryTool;

public class XMLDataFerryPluginConfiguration {

	// 数据摆渡

	@Bean
	@ConditionalOnMissingBean(ignored = DataFerryTool.class)
	public DataFerry defaultDataFerry(DataFileResolver dataFileResolver,
			DataObjectSourceOperator dataObjectSourceOperator) {
		return new DefaultDataFerry(dataFileResolver, dataObjectSourceOperator);
	}

	@Bean
	@ConditionalOnMissingBean
	public DataFerryTool dataFerryTool(DataFerry dataFerry) {
		return new DefaultXMLDataFerryTool(dataFerry);
	}

}
