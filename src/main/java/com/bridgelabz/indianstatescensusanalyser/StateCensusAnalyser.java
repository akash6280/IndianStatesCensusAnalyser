package com.bridgelabz.indianstatescensusanalyser;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bridgelabz.indianstatescensusanalyser.CensusAnalyserException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.Iterator;
public class StateCensusAnalyser {
	int countOfEntries=0;
	public int loadIndiaCensusData(String csvFilePath)throws CensusAnalyserException {
		
		try {
			if(!csvFilePath.contains(".csv")) {
				throw new CensusAnalyserException("Enter correct file type" , ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
			}
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator=csvToBean.iterator();
			
    		while(censusCSVIterator.hasNext()) {
    			countOfEntries++;
    		}
    		
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),ExceptionType.CENSUS_FILE_PROBLEM);
		}catch (RuntimeException e) {
            throw new CensusAnalyserException("Wrong data format", ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER);
        }
		return countOfEntries;
	}

}