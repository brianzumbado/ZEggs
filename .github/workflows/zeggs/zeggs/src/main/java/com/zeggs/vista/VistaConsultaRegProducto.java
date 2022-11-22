package com.zeggs.vista;

import com.zeggs.modelo.RegistroProductoModelo;
import com.zeggs.servicio.ServicioRegistroProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

/**
 *
 * @author Brian
 */
@Named
@ViewScoped
public class VistaConsultaRegProducto implements Serializable {

    @Inject
    private ServicioRegistroProducto servicioRegProd;

    @Getter
    @Setter
    private BarChartModel lineModel;
    @Getter
    @Setter
    private List<RegistroProductoModelo> listaRegProd;

    @PostConstruct
    public void init() {
//        createLineModel();
        cargarRegProdHoy();
    }

    public void cargarRegProdHoy() {
        listaRegProd = new ArrayList<>();
        listaRegProd = servicioRegProd.consultarRegProductoPorDia();
    }

    public void createLineModel() {
        lineModel = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet dataSet = new BarChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(5);
        values.add(2);
        values.add(7);
        values.add(3);
        values.add(10);
        dataSet.setData(values);
        dataSet.setLabel("Poas");
        dataSet.setBorderColor("rgb(255, 99, 132)");
        dataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        dataSet.setBorderWidth(1);

        BarChartDataSet dataSet2 = new BarChartDataSet();
        List<Number> values2 = new ArrayList<>();
        values2.add(6);
        values2.add(2);
        values2.add(4);
        values2.add(7);
        values2.add(9);
        values2.add(1);
        values2.add(5);
        dataSet2.setData(values2);
        dataSet2.setLabel("Viejas");
        dataSet2.setBorderColor("rgb(255, 159, 64)");
        dataSet2.setBackgroundColor("rgba(255, 159, 64, 0.2)");
        dataSet2.setBorderWidth(1);

        BarChartDataSet dataSet3 = new BarChartDataSet();
        List<Number> values3 = new ArrayList<>();
        values3.add(1);
        values3.add(1);
        values3.add(2);
        values3.add(1);
        values3.add(4);
        values3.add(2);
        values3.add(0);
        dataSet3.setData(values3);
        dataSet3.setLabel("Viejas");
        dataSet3.setBorderColor("rgb(201, 203, 207)");
        dataSet3.setBackgroundColor("rgba(201, 203, 207, 0.2)");
        dataSet3.setBorderWidth(1);

        data.addChartDataSet(dataSet);
        data.addChartDataSet(dataSet2);
        data.addChartDataSet(dataSet3);

        List<String> labels = new ArrayList<>();
        labels.add("Lunes");
        labels.add("Martes");
        labels.add("Miercoles");
        labels.add("Jueves");
        labels.add("Viernes");
        labels.add("Sabado");
        labels.add("Domingo");
        data.setLabels(labels);

        lineModel.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart");
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        lineModel.setOptions(options);

    }
}
