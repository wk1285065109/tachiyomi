package eu.kanade.mangafeed.ui.catalogue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.kanade.mangafeed.R;
import eu.kanade.mangafeed.data.database.models.Manga;

public class CatalogueAdapter extends FlexibleAdapter<CatalogueHolder, Manga> {

    private CatalogueFragment fragment;

    public CatalogueAdapter(CatalogueFragment fragment) {
        this.fragment = fragment;
        mItems = new ArrayList<>();
        setHasStableIds(true);
    }

    public void addItems(List<Manga> list) {
        mItems.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return mItems.get(position).id;
    }

    @Override
    public void updateDataSet(String param) {

    }

    @Override
    public CatalogueHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = fragment.getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.item_catalogue, parent, false);
        return new CatalogueHolder(v, this, fragment);
    }

    @Override
    public void onBindViewHolder(CatalogueHolder holder, int position) {
        final Manga manga = getItem(position);
        holder.onSetValues(manga, fragment.getPresenter());

        //When user scrolls this bind the correct selection status
        //holder.itemView.setActivated(isSelected(position));
    }

}
