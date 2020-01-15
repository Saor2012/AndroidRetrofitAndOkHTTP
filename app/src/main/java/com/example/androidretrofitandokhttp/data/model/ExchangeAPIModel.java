package com.example.androidretrofitandokhttp.data.model;

import com.google.gson.annotations.SerializedName;

public class ExchangeAPIModel {
	@SerializedName("sale")
	private String sale;
	@SerializedName("base_ccy")
	private String baseCcy;
	@SerializedName("buy")
	private String buy;
	@SerializedName("ccy")
	private String ccy;

	public void setSale(String sale){
		this.sale = sale;
	}

	public String getSale(){
		return sale;
	}

	public void setBaseCcy(String baseCcy){
		this.baseCcy = baseCcy;
	}

	public String getBaseCcy(){
		return baseCcy;
	}

	public void setBuy(String buy){
		this.buy = buy;
	}

	public String getBuy(){
		return buy;
	}

	public void setCcy(String ccy){
		this.ccy = ccy;
	}

	public String getCcy(){
		return ccy;
	}

	@Override
 	public String toString(){
		return 
			"ExchangeAPIModel{" +
			"sale = '" + sale + '\'' + 
			",base_ccy = '" + baseCcy + '\'' + 
			",buy = '" + buy + '\'' + 
			",ccy = '" + ccy + '\'' + 
			"}";
		}
}
