package com.ihsanobed.shared;

public class Verification {


    private static final String AT ="@";
    
/***********************************************************************************************
 *  We validate the Top Level Domain depending on IANA Root Zone Database                      *
 *  For more details visit this link "http://www.iana.org/domains/root/db/"                    *
 *  <- We don't include any TLD still under testing on IANA Root Zone Database ->              *
 ***********************************************************************************************
 */

	private static final String TLD[] = {

			"ac","ad","ae","aero","af","al","ai","am","an","ao","aq","ar","arpa","as","asia","at","au","aw","ax","az",
			"ba","bb","bd","bf","bg","bh","bi","biz","bj","bl","bm","bn","bq","br","bs","bt","bv","bw","by","bz",
			"ca","cat","cc","cd","cf","cg","ch","ci","ck","cl","cm","cn","co","com","coop","cr","cu","cv","cx","cy","cz",
			"de","dj","dk","dm","do","dz",
			"ec","edu","ee","eg","eh","er","es","et","eu",
			"fi","fj","fk","fm","fo","fr",
			"ga","gb","gd","ge","gf","gg","gi","gl","gm","gn","gov","gp","gq","gr","gs","gt","gu","gw","gy",
			"hk","hm","hr","ht","hu",
			"id","ie","il","im","in","info","int","io","iq","ir","is","it",
			"je","jm","jo","jobs","jp",
			"ke","kg","kh","ki","km","kn","kp","kr","kw","ky","kz",
			"la","lb","lc","li","lk","lr","ls","lt","lu","lv","ly",
			"ma","mc","md","me","mf","mg","mh","mil","mk","ml","mm","mn","mo","mobi","mp","mq","mr","ms","mt","mu","museum","mv","mw","mx","my","mz",
			"na","nc","net","nf","ng","ni","nl","no","np","nr","nu","nz",
			"om","org",
			"pa","pe","pf","pg","ph","pk","pn","pr","pro","ps","pt","pw","py",
			"qa",
			"re","ro","rs","ru","rw",
			"sa","sb","sc","sd","se","sg","sh","si","sj","sk","sl","sm","sn","so","sr","st","su","sv","sy","sz",
			"tc","td","tel","tf","tg","th","tj","tk","tl","tm","tn","to","tp","tr","travel","tt","tv","tw","tz",
			"ua","ug","uk","um","us","uy","uz",
			"va","vc","ve","vg","vi","vn","vu",
			"wf","ws",
			"ye","yt",
			"za","zm","zw"
			};

/***********************Starting email validation *******************************/

        public static String reFormat(String email){
            return (email.toLowerCase()).trim();
        }



	public static String stringAfterAt(String email){

            if (email.contains(AT)){

                int indexOfAT = email.lastIndexOf(AT);

                if ((email.substring(++indexOfAT)).equals("")){
                    return null;
                }
                else{
                    return email.substring(indexOfAT);
                }
            }

                
            return null;
           

	}///end of stringAfterAt///////--returning domain + dot + subdonain////

	public static String validTLD(String email){

            boolean valid = false;

            String currentTLD = "";

            String afterAt = Verification.stringAfterAt(email);

            if(afterAt != null){

                for (int i=0;i<TLD.length;i++) {

                    if (afterAt.endsWith("." + TLD[i])){

                        currentTLD = TLD[i];


                        valid = true;

                        break;

                    }// end of if

                }// end of loop

                if (valid){

                    return currentTLD;

                }

                else{
                    return null;
                }
            }
          
            else{

                return null;

            }// end of else that means no string 

		

	}// end of validTLD --- Returning the DOT + TLD -------

        public static String validDomain(String email){

            String domain = "";

            if(Verification.validTLD(email)!= null){

                int lastIndexOfAt = email.lastIndexOf(AT);
                int lastIndexOfTLDWithDot = email.lastIndexOf
                        (Verification.validTLD(email));

                domain = email.substring(++lastIndexOfAt, --lastIndexOfTLDWithDot);

                if (!domain.equals("")){
                    return domain;
                }
                else{
                    return null;
                }
            }
            else
            {
                return null;
            }

        }// end of validDomai

        public static String validEmailUserName(String email){

            int lastIndexOfAt = email.lastIndexOf(AT);

            String userName = email.substring(0, lastIndexOfAt);

            if (userName.equals("") || userName== null){
                return null;
            }
            else{
                return userName;
            }

        }// end of validEmailUserName



	public static boolean isValidEmail(String email) {
            String valid= Verification.reFormat(email);

            if(Verification.validDomain(valid) != null &&
               Verification.validTLD(valid) != null &&
               Verification.validEmailUserName(valid) != null){

                return true;

            }
            else{
                return false;
            }

		

	}// end of isValidEmail function


/***********************Ending email validation *******************************/


	public static boolean isValidPass(String name){

		if(name == null || name.length() < 5){

			return false;

		}// end of if statement

		return true;


	}// end of isValidName
}