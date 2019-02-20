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
	
	private TextField[] TFentradas;
	
	
	public String mostrarValoresIn() {
		String cadena="";
		
		if(TFentradas!=null) {
			for(int i=0; i<TFentradas.length;i++) {
				if(!TFentradas[i].getText().equals("")) {
					cadena+=TFentradas[i].getText()+",";
				}
			}
			
		}
		else
			System.out.print("no hay");
		
		return cadena;
	}
	
	@FXML
	public void calcular() {
		System.out.print(mostrarValoresIn());
		
		String[] valores=mostrarValoresIn().split(",");
		int total=0;
	
		for(int i=0;i<valores.length;i++) {
			total+= Integer.parseInt(valores[i]);
		}
		
		
		System.out.print(total);
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		TFentradas=new TextField[10];
		int posx=50;
		
		for(int i=0;i<10;i++) {	
			TextField e=new TextField();
			
			e.setLayoutY(100);
			e.setLayoutX(posx);
			e.setPrefSize(50, 20);
			TFentradas[i]=e;
			a.getChildren().add(e);
			
			posx+=70;
			
			System.out.println(posx);	
			
		}
		
		TFentradas[3].setLayoutY(120);
		
		
		
		
	}

}
