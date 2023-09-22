package Exercise;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Integer> holder = new TreeMap<>();
        holder.put("shards",0);
        holder.put("fragments",0);
        holder.put("motes",0);
        Map<String,Integer> junks = new TreeMap<>();
        boolean isWin = false;
        while (!isWin) {
            String[] data = scan.nextLine().split("\\s+");
            for (int i = 0; i < data.length-1; i+=2) {
                int quantity = Integer.parseInt(data[i]);
                String name = data[i+1].toLowerCase();
                if(name.equals("shards") || name.equals("fragments" ) ||name.equals("motes")){
                    holder.put(name,holder.get(name) + quantity);
                }else{
                    junks.putIfAbsent(name,0);
                    junks.put(name,junks.get(name)+quantity);
                }
                if(holder.get("shards")>=250){
                    isWin= true;
                    System.out.println("Shadowmourne obtained!");
                    holder.put("shards",holder.get("shards")-250);
                    break;
                }else if(holder.get("fragments")>=250){
                    isWin=true;
                    System.out.println("Valanyr obtained!");
                    holder.put("fragments",holder.get("fragments")-250);
                    break;
                }else if(holder.get("motes")>=250){
                    isWin=true;
                    System.out.println("Dragonwrath obtained!");
                    holder.put("motes",holder.get("motes")-250);
                    break;
                }
            }
        }
        holder.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder()))
                .forEach(leftOver-> System.out.printf("%s: %d\n",leftOver.getKey(),leftOver.getValue()));
        junks.entrySet().forEach(junk-> System.out.printf("%s: %d\n",junk.getKey(),junk.getValue()));
    }
}
