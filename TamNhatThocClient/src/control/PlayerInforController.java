package control;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.MatchHistory;

public class PlayerInforController {
	private Communication commu;
	

    public Communication getCommu() {
		return commu;
	}

	public void setCommu(Communication commu) {
		this.commu = commu;
	}
	
	@FXML
    private ImageView imageView;

    @FXML
    private ListView<String> listView;

    @FXML
    private PieChart pieChart;

    @FXML
    private Text scoreText;

    @FXML
    private Text usernameText;
    
    @FXML
    public void initialize() {
        // Dữ liệu giả cho PieChart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Chiến thắng", 70),
            new PieChart.Data("Thất bại", 20),
            new PieChart.Data("Hòa", 10)
        );
        pieChart.setData(pieChartData);

        // Dữ liệu giả cho ListView
        ObservableList<String> listViewData = FXCollections.observableArrayList(
            "1", "2", "3", "4"
        );
        listView.setItems(listViewData);

        // Dữ liệu giả cho Text
        usernameText.setText("Người Chơi A");
        scoreText.setText("Điểm: 1500");
    }

    @FXML
    void goBackButtonClick(ActionEvent event) {
    	commu.getNavigation().switchTo(commu.Pre_sence);
    	commu.getNavigation().resetScene("PlayerInfor.fxml");
    }
    public void setPieChartData(int win, int lose, int draw) {
    	int total = win + lose + draw;
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Chiến thắng", (float)win/total),
            new PieChart.Data("Thất bại", (float)lose/total),
            new PieChart.Data("Hòa", (float)draw/total)
        );
        pieChart.setData(pieChartData);
    }
    public void setListViewData(List<MatchHistory> matchHistoryList) {
        ObservableList<String> listViewData = FXCollections.observableArrayList();
        for (MatchHistory match : matchHistoryList) {
            listViewData.add(match.toString());
        }
        listView.setItems(listViewData);
    }
    public void setPlayerInfo(String username, float score) {
        usernameText.setText(username);
        scoreText.setText("Điểm: " + score);
    }
}
