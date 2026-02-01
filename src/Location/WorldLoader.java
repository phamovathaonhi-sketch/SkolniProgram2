package Location;
import Character.Player;
import Command.Command;

import java.util.HashMap;
import java.util.Scanner;
import Command.MovementCommand;
import Character.Character;
import Command.BattleCommand;
import Character.Enemy;
import Character.NPC;
import Command.DialogCommand;

public class WorldLoader {
    private World world;
    private Player player;
    private NPC npc;
    private Enemy enemy;
    private HashMap<String, Command> commands;
    boolean isRunning;


    public WorldLoader(){
        this.world = World.loadWorld("/gworld.json");
        this.player = player;
        Location start = world.findLocation(world.startLocation);
        player.setCurrentLocation(start);
    }

    public Directions parseDirection(String inp){
        if (inp==null || inp.isEmpty()){
            return null;
        }

        switch (inp.toLowerCase()){
            case "right"->{
                return Directions.RIGHT;
            }
            case "left"->{
                return Directions.LEFT;
            }
            case "front"->{
                return Directions.FRONT;
            }
            default ->{
                return null;
            }
        }

    }
    public Command processCommand(String input){
        String[] parts = input.split("",2);
        String action = parts[0].toLowerCase();
        String param = (parts.length > 1) ? parts[1] : "";

        Command command=null;
        switch (action){
            case "go" -> {
                Directions d = parseDirection(param);
                if (d != null) command = new MovementCommand(d, player, world);
            }
            case "attack"->{
               Character enemy = player.getCurrentLocation().getCharacter(param);
               if (enemy!= null){
                   command = new BattleCommand(player, player.getCurrentLocation().getEnemy() );
               }else{
                   System.out.println("No enemy exists");
               }
            }
            case "speak" ->{
               NPC target= player.getCurrentLocation().getNPC(param);

                if (target instanceof NPC){
                    NPC npc = target;
                    command = new DialogCommand(player, npc);
                }else{
                    System.out.println("non NPC existed");
                }
                if (command==null){
                    System.out.println("No matching command.");
                }
            }
            default ->{
                System.out.println("Please enter valid command.");
            }
        }
        return command;
    }


    public void start(){
        Scanner sc = new Scanner(System.in);
         isRunning = true;

        System.out.println("Welcome to the game");
        System.out.println(player.getCurrentLocation().getTheory());

        while(isRunning){
            String input = sc.nextLine().trim().toLowerCase();

            if (input.isEmpty()){
                continue;
            }
            Command command = processCommand(input);

            if (command != null){
                command.execute();
            }else{
                System.out.println("Please try again.");
            }
            if (player.isDefeated()){
                System.out.println(" You failed your mission.");
                isRunning=false;
            }
        }
    }





}
