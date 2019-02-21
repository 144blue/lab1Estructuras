package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class IndexController implements Initializable{
	
	@FXML private AnchorPane a;
	@FXML private Button BTcalcular;
	@FXML private TextField TFraices;
	
	private TextField[] TFentradas;
	private Main main;
	
	
	public String showElementIn() {
		String cadena="";
		
		if(TFentradas!=null) {
			for(int i=0; i<TFentradas.length;i++) {
				if(!TFentradas[i].getText().equals("")) 
					cadena+=TFentradas[i].getText()+",";
				else
					cadena+="0,";
				
			}
			
		}
		else
			System.out.print("no hay");
		
		return cadena;
	}
	
	@FXML
	public void calcular() {
		String[] elementsIn=showElementIn().split(",");
		int[] polyn=new int[elementsIn.length];
	
		for(int i=0;i<elementsIn.length;i++) {
			polyn[i]=Integer.parseInt(elementsIn[i]);
		}
		TFraices.setText(main.instance().methodNewtonRaphson(polyn, 5));
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		TFentradas=new TextField[11];
		int posx=30;
		
		for(int i=0;i<11;i++) {	
			TextField e=new TextField();
			
			e.setLayoutY(100);
			e.setLayoutX(posx);
			e.setPrefSize(50, 20);
			TFentradas[i]=e;
			a.getChildren().add(e);
			
			posx+=70;
			
			System.out.println(posx);	
			
		}
		
	}

}
