package com.codebasics.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public List<List<String>> findDuplicate(String[] paths) {
	        Map<String,List<String>> map = new HashMap();
	        List<List<String>> result = new ArrayList();
	        for(int i=0;i<paths.length;i++){
	            String s = paths[i];
	            String [] array = s.split(" ");
	            if(array.length<2) continue;
	            String path = array[0];
	            for(int j=1;j<array.length;j++){
	                String file = array[j];
	                int bIndex = file.indexOf('(');
	                String fileContent = file.substring(bIndex+1,file.length()-1);
	                String filePath = path+"/"+file.substring(0,bIndex);
	                List<String> list;
	                if(map.containsKey(fileContent)){
	                    list = map.get(fileContent);
	                }else{
	                    list = new ArrayList();
	                    map.put(fileContent,list);
	                }
	                list.add(filePath);
	            }
	        }
	        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
	            List<String> value = entry.getValue();
	            if(value.size()>1) result.add(value);
	        }
	        return result;
	    }
	}

}
