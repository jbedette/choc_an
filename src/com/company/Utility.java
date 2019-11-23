package com.company;

public class Utility {
    public static String[] sanitizeReadWrite( boolean read, String [] in){
        String [] out = in;
        for(int i = 0; i < out.length-1; ++i){
            if(read) {
                out[i] = out[i].replace('_', ' ');
            }
            else {
                out[i] = out[i].replace(' ', '_');
            }
        }
        return out;
    }
}
