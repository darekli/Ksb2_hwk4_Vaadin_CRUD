package ksb2_cars_Vaadin_hwk4_v2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Home")
//@Theme(value = Lumo.class, variant = Lumo.DARK)
public class HomeViewGui extends Composite<VerticalLayout> implements HasComponents {

    public HomeViewGui() {
        Image image = new Image("https://gazeo.pl/images/gazeo_2018/Wiadomosci/Nowe_samochody_LPG_teoretyczna_alternatywa/Samochody-LPG-2017.jpg", "DummyImage");
        Button buttonDarkMode = new Button("Dark mode", click -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();
            if(themeList.contains(Lumo.DARK)) {
                themeList.remove(Lumo.DARK);
            }else {
                themeList.add(Lumo.DARK);
            }
        });

        getContent().setSizeFull();
        com.vaadin.flow.component.html.H2 pageName = new H2("Home menu");
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, pageName);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, image);
        add(buttonDarkMode,pageName,image);
    }


}
