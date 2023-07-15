package presenter;

import model.ControlModel;
import view.MyFrame;

import java.awt.event.ActionListener;

public class ManagerGeneral {
    private Contract.Presenter presenter;
    private Contract.Model model;
    private Contract.View view;

    public ManagerGeneral() {
    }

    public void createMVP() {
        presenter = new Presenter();
        ActionListener listener = presenter.getListener();
        model = new ControlModel();
        view = new MyFrame(listener, model.getPersistenceData().getProperties());


        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
        model.setPresenter(presenter);
        
    }

    public void run() {
        createMVP();
        presenter.run();
    }
}
