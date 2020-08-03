package Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import View.GUI;
import View.menu;
import View.winner;
import engine.Game;
import model.cards.minions.Minion;
import model.cards.spells.*;
import model.heroes.*;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;

public class Controller implements ActionListener {
		private Game model;	
		private GUI GameView;
		private menu heroes;
		private winner winner;
		Hero p1;
		Hero p2;
		JButton selectedHero;
		JButton Start;
		JButton chname;
		JButton oname;
		int mtarget;
		boolean htarget;
		JTextArea m;
		JTextArea n;
		boolean flag;
	
	public Controller() throws FullHandException, CloneNotSupportedException {	
		p1=null;
		p2=null;
		heroes = new menu();
		
		JButton hero1 = new JButton("Choose your First Hero");
		JButton hero2 = new JButton("Choose your Second Hero");
		JButton Start = new JButton("Start Game!");
		Start.setFont(new Font("serif", Font.ITALIC , 40));
		Start.setBackground(Color.GREEN);
		hero1.setFont(new Font("serif", Font.BOLD , 40));
		hero1.setBackground(Color.ORANGE);
		hero2.setFont(new Font("serif", Font.BOLD , 40));
		hero2.setBackground(Color.ORANGE);
		hero1.addActionListener(this);
		hero2.addActionListener(this);
		Start.addActionListener(this);
		heroes.add(hero1);
		heroes.add(Start);
		heroes.add(hero2);
		
		JButton  x = new JButton("Exit");
		x.setFont(new Font("serif", Font.BOLD , 40));
		x.setBackground(Color.RED);
		x.addActionListener(this);
		heroes.add(x);
		
		x= new JButton("Mage");
		x.setFont(new Font("serif", Font.BOLD , 40));
		x.setBackground(Color.CYAN);
		x.addActionListener(this);
		heroes.add(x);
		
		x= new JButton("Warlock");
		x.setFont(new Font("serif", Font.BOLD , 40));
		x.setBackground(Color.CYAN);
		x.addActionListener(this);
		heroes.add(x);
		
		x= new JButton("Hunter");
		x.setFont(new Font("serif", Font.BOLD , 40));
		x.setBackground(Color.CYAN);
		x.addActionListener(this);
		heroes.add(x);
		
		x= new JButton("Priest");
		x.setFont(new Font("serif", Font.BOLD , 40));
		x.setBackground(Color.CYAN);
		x.addActionListener(this);
		heroes.add(x);
		
		x= new JButton("Paladin");
		x.setFont(new Font("serif", Font.BOLD , 40));
		x.setBackground(Color.CYAN);
		x.addActionListener(this);
		heroes.add(x);
		
		flag = false;
		
		JOptionPane.showMessageDialog(null, "Choose a Hero then select 'Choose first hero'. Then do the same for Second Hero.");
	}
	public static void main(String[] args) throws FullHandException, CloneNotSupportedException {
		new Controller();
	}
	public void actionPerformed(ActionEvent z) {
			JButton x=(JButton) z.getSource();
				
			if(x.getActionCommand().equals("Exit"))
				System.exit(0);
				else if(x.getActionCommand().equals("Choose your First Hero") && selectedHero.getActionCommand().equals("Mage"))
				try {
						p1=new Mage();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Movement invalid!");				}
				else if(x.getActionCommand().equals("Choose your First Hero") &&selectedHero.getActionCommand().equals("Warlock"))
					try {					
						p1=new Warlock();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Movement invalid!");				}
				else if(x.getActionCommand().equals("Choose your First Hero") &&selectedHero.getActionCommand().equals("Hunter"))
					 try {					
						p1=new Hunter();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Movement invalid!");				}
				else if(x.getActionCommand().equals("Choose your First Hero") &&selectedHero.getActionCommand().equals("Priest"))
					try {					
						p1=new Priest();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Movement invalid!");				}
				else if(x.getActionCommand().equals("Choose your First Hero") &&selectedHero.getActionCommand().equals("Paladin"))
					try {
					p1=new Paladin();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Movement invalid!");				}
				
				
				
				else if(x.getActionCommand().equals("Choose your Second Hero") && selectedHero.getActionCommand().equals("Mage")) 
						try {			
						p2=new Mage();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Invalid!");				
					}
				else if(x.getActionCommand().equals("Choose your Second Hero") && selectedHero.getActionCommand().equals("Warlock"))
						try {					
						p2=new Warlock();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Invalid!");				
					}
				else if(x.getActionCommand().equals("Choose your Second Hero") && selectedHero.getActionCommand().equals("Hunter"))
						try {			
						p2=new Hunter();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Invalid!");				
					}
				else if(x.getActionCommand().equals("Choose your Second Hero") && selectedHero.getActionCommand().equals("Priest"))
						try {			
						p2=new Priest();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Invalid!");				
					}
				else if(x.getActionCommand().equals("Choose your Second Hero") && selectedHero.getActionCommand().equals("Paladin" ))
						try {
						p2=new Paladin();
				} catch (IOException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Invalid!");				
					}
								
				else if(x.getActionCommand().equals("Mage") || x.getActionCommand().equals("Warlock")||
					x.getActionCommand().equals("Hunter")||x.getActionCommand().equals("Priest")||x.getActionCommand().equals("Paladin"))
				selectedHero = x;
				
				
				else if(x.getActionCommand().equals("Start Game!") && p1 != null && p2!=null){
					heroes.dispose();
				try {
					model = new Game(p1 , p2);
				} catch (FullHandException | CloneNotSupportedException e) {
					JOptionPane.showMessageDialog(null, "Can not Start Game!");				
					}
				GameView = new GUI();
				GameView.getPower().addActionListener(this);
				GameView.getEnd().addActionListener(this);
				mtarget = -1;
				htarget = false;
				flag = true;
				}				
			
				if(p1!=null && p2!=null && x.getActionCommand().equals("Use Hero Power!")){
					try {
						model.getCurrentHero().useHeroPower();
						GameView.getPower().setText("Hero power used.");
					}
					catch (NotYourTurnException e) {
							JOptionPane.showMessageDialog(null, "This is not your Turn");
					}
					catch(HeroPowerAlreadyUsedException e){
							JOptionPane.showMessageDialog(null, "Hero power has already been used");
					}
					catch(FullFieldException e){
							JOptionPane.showMessageDialog(null, "Full Field Exception");
					}
					catch(FullHandException e){
						JOptionPane.showMessageDialog(null, "Full Hand Exception");
					}
					catch(CloneNotSupportedException e){
						JOptionPane.showMessageDialog(null, "Clone Not Supported Exception");
					}
					catch(NotEnoughManaException e){
						JOptionPane.showMessageDialog(null, "You do not have enough mana");
					}					
				}
				
				if(flag == true){
				for(int i = 0 ; i <  model.getCurrentHero().getHand().size() ; i++){
				if(x.getActionCommand().equals("H" + model.getCurrentHero().getHand().get(i).getName()) &&
						model.getCurrentHero().getHand().get(i) instanceof Minion){ 
					try {
						model.getCurrentHero().playMinion((Minion)model.getCurrentHero().getHand().get(i));
						break;
					} catch (NotYourTurnException e) {
						JOptionPane.showMessageDialog(null, "This is not your Turn");
				}
					catch(NotEnoughManaException e){
						JOptionPane.showMessageDialog(null, "You do not have enough mana");
					}
					catch(FullFieldException e){
						JOptionPane.showMessageDialog(null, "Full Field Exception");
					}
				}
				
				else if(x.getActionCommand().equals("H" + model.getCurrentHero().getHand().get(i).getName()) &&
						model.getCurrentHero().getHand().get(i) instanceof Spell){
					
					if(model.getCurrentHero().getHand().get(i) instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell) (model.getCurrentHero().getHand().get(i)),model.getOpponent().getField());
						JOptionPane.showMessageDialog(null, "Spell Played");
						break;
					} catch (NotYourTurnException e) {
						JOptionPane.showMessageDialog(null, "This is not your Turn");
				}
					catch(NotEnoughManaException e){
						JOptionPane.showMessageDialog(null, "You do not have enough mana");
					}}
					
					else if(model.getCurrentHero().getHand().get(i) instanceof LeechingSpell){
						if( mtarget != -1){
							try {
							model.getCurrentHero().castSpell((LeechingSpell) (model.getCurrentHero().getHand().get(i)), 
									model.getOpponent().getField().get(mtarget));
								JOptionPane.showMessageDialog(null, "Spell Played");
					} catch (NotYourTurnException e) {
						JOptionPane.showMessageDialog(null, "This is not your Turn");
					}
					catch(NotEnoughManaException e){
						JOptionPane.showMessageDialog(null, "You do not have enough mana");
					}}
						else{
							JOptionPane.showMessageDialog(null, "not played, Please Select a Minion.");
							}
						mtarget = -1;
						break;
						}
					
					else if(model.getCurrentHero().getHand().get(i) instanceof MinionTargetSpell){
						if( mtarget != -1){
						try {
						model.getCurrentHero().castSpell((MinionTargetSpell) (model.getCurrentHero().getHand().get(i)), 
								model.getOpponent().getField().get(mtarget));
							JOptionPane.showMessageDialog(null, "Spell Played");
					}catch (NotYourTurnException e) {
						JOptionPane.showMessageDialog(null, "This is not your Turn");
					}
						catch(NotEnoughManaException e){
						JOptionPane.showMessageDialog(null, "You do not have enough mana");
					}
					catch(InvalidTargetException e){
							JOptionPane.showMessageDialog(null, "Invalid Target");
					}
				}
						else{
							JOptionPane.showMessageDialog(null, "not played, Please Select a Minion.");
						}
						mtarget=-1;
						break;
					}
					
					else if(model.getCurrentHero().getHand().get(i) instanceof FieldSpell){
						try {
							model.getCurrentHero().castSpell((FieldSpell) (model.getCurrentHero().getHand().get(i)));
							JOptionPane.showMessageDialog(null, "Spell Played");
							break;
						} catch (NotYourTurnException e) {
							JOptionPane.showMessageDialog(null, "This is not your Turn");
					}
						catch(NotEnoughManaException e){
							JOptionPane.showMessageDialog(null, "You do not have enough mana");
						}
					}
					
					
					else if(model.getCurrentHero().getHand().get(i) instanceof HeroTargetSpell){
						try {
							model.getCurrentHero().castSpell((HeroTargetSpell) (model.getCurrentHero().getHand().get(i)), model.getOpponent());
							JOptionPane.showMessageDialog(null, "Spell Played");
							break;		
						} catch (NotYourTurnException e) {
							JOptionPane.showMessageDialog(null, "This is not your Turn");
					}
						catch(NotEnoughManaException e){
							JOptionPane.showMessageDialog(null, "You do not have enough mana");
						}
					}					
				}
				}
				
				for(int i = 0 ; i < model.getOpponent().getField().size(); i++){
					if(x.getActionCommand().equals("O" + model.getOpponent().getField().get(i).getName())){
						if(htarget == true){
							JOptionPane.showMessageDialog(null, "The Opponent Hero is already Selected.");}
						else{
						mtarget = i ;
						JOptionPane.showMessageDialog(null, "Minion Selected.");
					}
				}
			}
								
				if(x.getActionCommand().equals(model.getOpponent().getName())){
					if(mtarget == -1){
						htarget = true;
						JOptionPane.showMessageDialog(null, "Hero Selected.");}
					else{
						JOptionPane.showMessageDialog(null, "A minion is already Selected.");
				}
			}
				
				for(int i = 0 ; i < model.getCurrentHero().getField().size(); i++){
					if(x.getActionCommand().equals("F" + model.getCurrentHero().getField().get(i).getName())){
							if(mtarget == -1 && htarget == true){
							try {
								model.getCurrentHero().attackWithMinion(model.getCurrentHero().getField().get(i) ,
											model.getOpponent());
								JOptionPane.showMessageDialog(null, "Hero Attacked.");						
								
							} catch (CannotAttackException e) {
								JOptionPane.showMessageDialog(null, "Can not Attack Exception.");
							} catch (NotYourTurnException e) {
								JOptionPane.showMessageDialog(null, "This is not your Turn.");
							} catch (TauntBypassException e) {
								JOptionPane.showMessageDialog(null, "The opponent has a taunt minion.");
							} catch (NotSummonedException e) {
								JOptionPane.showMessageDialog(null, "Not Summoned Exception.");
							} catch (InvalidTargetException e) {
								JOptionPane.showMessageDialog(null, "This Target is Invalid.");
							}
							htarget = false;
							break;
								}
							else if(htarget == false && mtarget != -1){
								try {
									model.getCurrentHero().attackWithMinion(model.getCurrentHero().getField().get(i) , model.getOpponent().getField().get(mtarget));
									JOptionPane.showMessageDialog(null, "Minion Attacked.");
									
								} catch (CannotAttackException e) {
									JOptionPane.showMessageDialog(null, "Can not Attack Exception.");
								} catch (NotYourTurnException e) {
									JOptionPane.showMessageDialog(null, "This is not your Turn.");
								} catch (TauntBypassException e) {
									JOptionPane.showMessageDialog(null, "The opponent has a taunt minion.");
								} catch (NotSummonedException e) {
									JOptionPane.showMessageDialog(null, "Not Summoned Exception.");
								} catch (InvalidTargetException e) {
									JOptionPane.showMessageDialog(null, "This Target is Invalid.");
								}
								mtarget = -1;
								break;
								}
							else
								JOptionPane.showMessageDialog(null, "Please select a minion or a hero to attack.");
						}
					}
				
				if(x.getActionCommand().equals("End Turn")){
					try{					
						model.endTurn();
						GameView.getPower().setText("Use Hero Power!");
						JOptionPane.showMessageDialog(null, "Turn ended");
						mtarget = -1;
						htarget = false;
						}		
					catch (FullHandException e){
						JOptionPane.showMessageDialog(null, "FullHandException:" + "\n" + "Can't end turn now");
					}
					catch(CloneNotSupportedException e){
						JOptionPane.showMessageDialog(null, "CloneNotSupportedException:" + "\n" + "Can't end turn now");
					}
				}
				updating();
				if(model.getCurrentHero().getCurrentHP() == 0 ){
					GameView.dispose();
					JLabel win = new JLabel("The Winner is the Second Player:" + model.getOpponent().getName());
					win.setFont(new Font("Arial" , Font.BOLD , 27));
					winner = new winner();
					winner.getWin().add(win);}
				else if(model.getOpponent().getCurrentHP() == 0 ){
					GameView.dispose();
					JLabel win = new JLabel("The Winner is the First Player:" + model.getCurrentHero().getName());
					win.setFont(new Font("Arial" , Font.BOLD , 27));
					winner = new winner();
					winner.getWin().add(win);
				}	
			}
		}
	
	
	public void updating(){
		chname = new JButton( model.getCurrentHero().getName());
		chname.setSize(2, 3);
		chname.setFont(new Font("Serif" , Font.ITALIC , 23));
		chname.setBackground(Color.ORANGE);
		chname.addActionListener(this);
		
		oname = new JButton( model.getOpponent().getName());
		oname.setSize(2, 3);
		oname.setFont(new Font("Serif" , Font.ITALIC , 23));
		oname.setBackground(Color.ORANGE);
		oname.addActionListener(this);
		
		GameView.getW().removeAll();		
		GameView.getR().removeAll();
		
		n = new JTextArea(3,7);
		m = new JTextArea(3,7);
		n.setText("Current HP:"+ model.getCurrentHero().getCurrentHP() +"\n"+"Current ManaCrystals:"+
				model.getCurrentHero().getCurrentManaCrystals()+"\n"+"Total ManaCrystals:" + model.getCurrentHero().getTotalManaCrystals()+"\n"
				+"Remaining in Deck:"+model.getOpponent().getDeck().size());
		m.setText("Current HP:"+ model.getOpponent().getCurrentHP() + "\n"+"Current ManaCrystals:"+
				model.getOpponent().getCurrentManaCrystals() +"\n"+"Total ManaCrystals:" + model.getOpponent().getTotalManaCrystals()+"\n"+"Remaining in Hand:"+
				model.getOpponent().getHand().size()+"\n"+"Remaining in Deck:"+model.getOpponent().getDeck().size());
		n.setFont(new Font("Arial", Font.PLAIN , 20));
		m.setFont(new Font("Arial", Font.PLAIN , 20));
		
		GameView.getW().add(chname);
		GameView.getR().add(oname);
		GameView.getW().add(n);
		GameView.getR().add(m);
		GameView.getCh().add(GameView.getW() , BorderLayout.WEST);
		GameView.getO().add(GameView.getR() , BorderLayout.WEST);
		
		
		GameView.getHand().removeAll();
		for(int i = 0 ; i< model.getCurrentHero().getHand().size() ; i++){

			if(model.getCurrentHero().getHand().get(i) instanceof Minion){
				boolean divine =true;
				boolean taunt = true;
				boolean charge= true;
				boolean sleeping = true;
				Minion mcard = (Minion) model.getCurrentHero().getHand().get(i);
				if(mcard.isTaunt()){
					taunt = true;}
					else{
					taunt = false;
					}
				if(mcard.isDivine())
					divine = true;
				else 
					divine = false;
				
				if(mcard.isSleeping())
					charge = false;
					else
					sleeping = false;
				JTextArea text = new JTextArea(30,30);
				text.setText("Name:" + mcard.getName()+ "," +" Rarity:"+ mcard.getRarity()+"\n" +" Manacost:"+
						mcard.getManaCost() +"\n"+" Attack:"+mcard.getAttack()
						+","+" Current HP:"+mcard.getCurrentHP()+"\n"+"Divine:"+divine+","+" Taunt:"+taunt +"\n"+
						" Charge:"+charge+","+" Sleeping:"+sleeping);
				JButton card = new JButton("H" + mcard.getName());
				text.setEditable(false);
				card.setBackground(Color.CYAN);
				text.setFont(new Font("Arial" , Font.PLAIN , 15));
				card.add(text);
				card.addActionListener(this);
				GameView.getHand().add(card);
			}				
			else{					
			JTextArea text = new JTextArea();
						text.setText("Name:" +model.getCurrentHero().getHand().get(i).getName()+ "\n" +
						 " Rarity:" + model.getCurrentHero().getHand().get(i).getRarity()+ "\n" +
						 "Manacost:" + model.getCurrentHero().getHand().get(i).getManaCost()) ;
			JButton card = new JButton("H" + model.getCurrentHero().getHand().get(i).getName());
			text.setEditable(false);
			card.setBackground(Color.CYAN);
			text.setFont(new Font("Arial" , Font.PLAIN , 15));			
			card.add(text);
			card.addActionListener(this);
			GameView.getHand().add(card);
			}				
		}
		
		GameView.getChfield().removeAll();
		for(int i = 0 ; i< model.getCurrentHero().getField().size() ; i++){
			
				boolean divine =true;
				boolean taunt = true;
				boolean charge= true;
				boolean sleeping = true;
				Minion mcard = (Minion) model.getCurrentHero().getField().get(i);
				if(mcard.isTaunt()){
					taunt = true;}
					else{
					taunt = false;
					}
				if(mcard.isDivine())
					divine = true;
				else 
					divine = false;
				
				if(mcard.isSleeping())
					charge = false;
					else
					sleeping = false;
				JTextArea text = new JTextArea(30,30);
				text.setText("Name:" + mcard.getName()+ ","  +" Rarity:"+ mcard.getRarity()+"\n" +" Manacost:"+
						mcard.getManaCost() +"\n"+" Attack:"+mcard.getAttack()
						+","+" Current HP:"+mcard.getCurrentHP()+"\n"+"Divine:"+divine+","+" Taunt:"+taunt +"\n"+
						" Charge:"+charge+","+" Sleeping:"+sleeping);
				JButton card = new JButton("F" + mcard.getName());
				text.setEditable(false);
				card.setBackground(Color.CYAN);
				text.setFont(new Font("Arial" , Font.PLAIN , 15));
				card.add(text);
				card.addActionListener(this);
				GameView.getChfield().add(card);
			}				
		
		GameView.getOfield().removeAll();
		for(int i = 0 ; i< model.getOpponent().getField().size() ; i++){
				boolean divine =true;
				boolean taunt = true;
				boolean charge= true;
				boolean sleeping = true;
				Minion mcard = (Minion) model.getOpponent().getField().get(i);
				if(mcard.isTaunt()){
					taunt = true;}
					else{
					taunt = false;
					}
				if(mcard.isDivine())
					divine = true;
				else 
					divine = false;
				
				if(mcard.isSleeping())
					charge = false;
					else
					sleeping = false;
				JTextArea text = new JTextArea(30,30);
				text.setText("Name:" + mcard.getName()+ ","  +" Rarity:"+ mcard.getRarity()+"\n" +" Manacost:"+
						mcard.getManaCost()+"\n"+" Attack:"+mcard.getAttack()
						+","+" Current HP:"+mcard.getCurrentHP()+"\n"+"Divine:"+divine+","+" Taunt:"+taunt +"\n"+
						" Charge:"+charge+","+" Sleeping:"+sleeping);
				JButton card = new JButton("O" + model.getOpponent().getField().get(i).getName());
				text.setEditable(false);
				card.setBackground(Color.CYAN);
				text.setFont(new Font("Arial" , Font.PLAIN , 15));
				card.add(text);
				card.addActionListener(this);
				GameView.getOfield().add(card);
			}
		
		GameView.revalidate();
		GameView.repaint();
		GameView.setVisible(true);
		}
	}




	

