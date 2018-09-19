/*import java.io.File; */
import java.util.Scanner; 
import java.util.Arrays;
public class socialNetworkk 
{ 
	socialNetworkk() {

	}
  public static void main(String[] args) throws Exception 
  { 
    // pass the path to the file as a parameter 
    AddUser u = new AddUser();
    /*File file = 
      new File("C:\\Users\\Zone\\Desktop\\my practise\\testcase.txt"); */
/*    Scanner sc = new Scanner(file);*/
    Scanner scan = new Scanner(System.in);
    String[] cnt = scan.nextLine().split(" ");
    for (int i = 0; i < Integer.parseInt(cnt[1]); i++) {
  	            String line = scan.nextLine();
            String[] tokens = line.split(" is connected to ");
            u.addName(new User(tokens[0], tokens[1].replace(" ", "").replace(".","").split(",")));
        }
    while (scan.hasNextLine()) {
    	String line1 = scan.nextLine();
    	String[] token = line1.split(" ");
    	switch (token[0]) {
    		case "getConnections":
    		if (u.getConnections(token[1]) == null) {
    			System.out.println("Not a user in Network");
    		} else{
    		System.out.println(u.getConnections(token[1])); }
    		break;
    		case "addConnections":
    		u.addConnection(token[1], token[2]);
    		break;
    		case "CommonConnections":
    		System.out.println(Arrays.toString(u.getCommonlist(token[1], token[2])));
    		break;
    		case "Network":
    		u.network();
    		break;
    		default:
    	}
    	
    }
}
}

/*C:\\Users\\Zone\\Desktop\\CSPP-2-assignments\\assignments\\m22\\SocialNetwork.txt*/

class AddUser {
	private int size;
	private User[] network;
	AddUser() {
		size = 0;
		network = new User[30];
	}

    String getConnections(String s) {
    	int k = 0;
    	for (int i = 0; i < size; i++) {
    		if (s.equals(network[i].getname())) {
    			k = 1;
    		}
    	}
    	if (k == 1) {
    		for (int i = 0; i < size; i++) {
				if (s.equals(network[i].getname())) {

					return network[i].getConnectionslist();
    			} 
    		}
    	}
    		return null; 	
    }

    void addName(User v) {
    	User temp = new User();
		network[size++] = v;
    	    for (int i = 0; i < size - 1; i++) 
        {
            for (int j = i + 1; j < size; j++) 
            {
                if (network[i].getname().compareTo(network[j].getname())>0) 
                {
                    temp = network[i];
                    network[i] = network[j];
                    network[j] = temp;
                }
            }

    }
}
    void addConnection(String username, String newName) {
    	int k =0, z = 0;
    	for (int i = 0; i < size; i++) {
    		if (network[i].getname().equals(username)) {
    			k = 1;
    		}
    	}
    	for (int i = 0; i < size; i++) {
    		if (network[i].getname().equals(newName)) {
    			z = 1;
    		}
    	}
    		if (k ==1 && z == 1) {
    			for (int i = 0; i < size; i++) {
    		if(network[i].getname().equals(username)) {
    			network[i].setlistname(newName);
    			break;
    		} 
    		}
    	} else {
    			System.out.println("Not a user in Network");
    	}
    }
    String[] getCommonlist(String username, String newName) {
    	int k = 0, l = 0;
    	int cnt = 0;
    	for(int i = 0; i < size; i++) {
    		if (network[i].getname().equals(username)) {
    			k = i;
    		}
    		if (network[i].getname().equals(newName)) {
    			l = i;
    		}
    	}
    	    String[] commonlist = new String[Math.min(network[k].connectednames().length, network[l].connectednames().length)];
    		String[] usernamelist = new String[network[k].connectednames().length];
    		usernamelist = network[k].connectednames();
    		String[] newNamelist = new String[network[l].connectednames().length];
    		newNamelist = network[l].connectednames();
    			for(int i = 0; i < usernamelist.length; i++) {
    				for(int j = 0; j < newNamelist.length; j++) {
    					if (usernamelist[i].equals(newNamelist[j])) {
    						commonlist[cnt++] = usernamelist[i];
    					}
    				}
    			}
    			String[] commonlist1 = new String[cnt];
    			for(int i = 0; i < cnt; i++) {
    				commonlist1[i] = commonlist[i];
    			}
    			if(cnt == 0) { 
    				return commonlist1;
    			}		
    	return commonlist1;
    }
    void network() {
    	int i;
    	for (i = 0; i < size-1; i++) {
    	System.out.print(network[i].getname() + ": "+ network[i].getConnectionslist()+", ");
    }
    System.out.println(network[i].getname() + ": "+ network[i].getConnectionslist());
    }
}
class User {
	private String userName;
	private String[] connectedNames;
	User() {

	}

	User(String name, String[] connectednames) {
		this.userName = name;
		this.connectedNames = connectednames;
/*		System.out.println(getConnectionslist());*/
	}
	String getname() {
		return userName;
	}
	String[] connectednames() {
		return connectedNames;
	}
	void setlistname(String newName) {
		String[] newconnectedNames = new String[connectedNames.length + 1];
		System.arraycopy(connectedNames, 0, newconnectedNames, 0, connectedNames.length);
		newconnectedNames[connectedNames.length] = newName;
		connectedNames = newconnectedNames;
	}
	String getConnectionslist() {
		String str = "[";
		for (int i = 0; i < connectedNames.length - 1; i++) {
			str += connectedNames[i] + ", ";
		}
		str += connectedNames[connectedNames.length - 1]  + "]";
		return str;
	}
}
/*Arrays.toString(connectedNames)*/