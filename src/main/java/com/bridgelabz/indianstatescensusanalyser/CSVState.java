package com.bridgelabz.indianstatescensusanalyser;

import com.opencsv.bean.CsvBindByName;
public class CSVState{
	    @CsvBindByName(column = "SrNo", required = true)
	    public int srNo;
	    @CsvBindByName(column = "State Name", required = true)
	    public String stateName;
	    @CsvBindByName(column = "TIN", required = true)
	    public int tin;
	    @CsvBindByName(column = "StateCode", required = true)
	    public String stateCode;
	    @Override
	    public String toString() 
	    {
	        return "IndiaStateCSV{" +
	                "SrNo=" + srNo +
	                ", state='" + stateName + '\'' +
	                ", TIN=" + tin +
	                ", stateCode='" + stateCode + '\'' +
	                '}';
	    }   
}
