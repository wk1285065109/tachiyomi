package eu.kanade.mangafeed.presenter;

import javax.inject.Inject;

import eu.kanade.mangafeed.data.helpers.SourceManager;
import eu.kanade.mangafeed.sources.Source;
import eu.kanade.mangafeed.ui.fragment.SourceFragment;


public class SourcePresenter extends BasePresenter<SourceFragment> {

    @Inject SourceManager sourceManager;

    @Override
    protected void onTakeView(SourceFragment view) {
        super.onTakeView(view);

        view.setItems(sourceManager.getSources());
    }

}