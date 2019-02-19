import java.util.*;


public class Ricorsione{
	
    public static void main(String[] args) {

        String alph = "012345";
        String seq = "";
        
        Scanner sc = new Scanner(System.in);

        System.out.println("insert 0 1 2 3 or 4");

        String a = sc.next();
        seq = seq.concat(a);
             
        System.out.println(seq);
        rico(seq,alph);
    }
    public static void rico(String seq,String alph){
    	
    	if (seq.length() > 200)
    		System.exit(1);
        
        for(int i=0;i<=4;i++){
            seq = seq.concat(alph.substring(i,i+1));
            System.out.print(seq);
            int lung = seq.length(); 
            int l = 1;
            int OK = 1;
            while(l <= lung/2  &&  OK == 1){
                String a = seq.substring(lung-l);
                
                String ba = seq.substring(lung-(2*l),lung-l);
                System.out.println("\t Sequence a:\""+a+"\" "
                		+ "Sequence b: \""+ba+"\"");
                    int b = dHamming(a,ba);
            
                    if (b <= l*0.5)
                        OK = 0;
                    l++;
                }
                if(OK > 0){
                    System.out.println(seq);
                    rico(seq,alph);
                }
                seq=seq.substring(0,lung-1);
                System.out.println(seq);
   }
}

	public static int dHamming(String subseq,String subseq2){
        int dist=0;
        System.out.println(subseq+ " " +subseq2);
        for(int j=0 ; j<subseq.length(); j++){
            if(subseq.charAt(j) != subseq2.charAt(j))
				dist=dist+1;
        }
        System.out.println("Hamming's distance = " +dist);
        return dist;
    }

}
