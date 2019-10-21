package ksb2_cars_Vaadin_hwk4_v2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

@Route("home2")
public class MainLayout extends Composite<VerticalLayout> implements HasComponents, RouterLayout {

    private Div childWrapper = new Div();

    public MainLayout() {
        getContent().setSizeFull();

        H1 header = new H1("WELCOME TO SHOW CARS!");
        add(header);

        HorizontalLayout mainContent = new HorizontalLayout();
        VerticalLayout menuBar = new VerticalLayout();
        menuBar.setWidth("20%");

        menuBar.add(new RouterLink("Home", HomeViewGui.class));
        menuBar.add(new RouterLink("Show cars", CarsShowGui.class));
        menuBar.add(new RouterLink("Add car", CarAddGui.class));
        menuBar.add(new RouterLink("Modify", CarFieldModGui.class));
        menuBar.add(new RouterLink("Remove", CarRemoveGui.class));
        menuBar.add(new RouterLink("Show cars by colour", CarsColourShowGui.class));

        mainContent.add(menuBar);

        mainContent.add(childWrapper);
        mainContent.setFlexGrow(1, childWrapper);

        add(mainContent);

        H1 footer = new H1("_______________________________________________________________________________________________________________");

        add(footer);

        getContent().setFlexGrow(1, mainContent);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, header);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, footer);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH, mainContent);
    }

}

