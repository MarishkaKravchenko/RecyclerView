package com.marishkakravchenko.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myDataset = getDataSet();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // если мы уверены, что изменения в контенте не изменят размер layout-а RecyclerView
        // передаем параметр true - это увеличивает производительность
        mRecyclerView.setHasFixedSize(true);

        /* LayoutManager. Для использования RecyclerView кроме адаптера вам необходимо передать ему с помощью метода setLayoutManager() объект класса, реализующего LayoutManager. Этот класс отвечает за работу с адаптером, именно он решает, переиспользовать View или создать новый, и соответственно, именно он дёргает методы onCreateViewHolder(), onBindViewHolder() и getItemCount() адаптера. Пока доступна только одна реализация этого класса — LinearLayoutManager, для создания кастомного LayoutManager, необходимо унаследоваться от RecyclerView.LayoutManager.
 */
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }


    private String[] getDataSet() {

        String[] mDataSet = new String[20];
        for (int i = 0; i < 20; i++) {
            mDataSet[i] = "item" + i;
        }
        return mDataSet;
    }
}
