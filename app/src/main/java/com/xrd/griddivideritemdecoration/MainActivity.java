package com.xrd.griddivideritemdecoration;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv=findViewById(R.id.rv);
        for (int i = 0; i < 20; i++) {
            list.add("条目"+i);
        }
        rv.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
        rv.setAdapter(new MyAdapter(this,list));
        rv.addItemDecoration(new GridDividerItemDecoration(this));
    }
    class MyAdapter extends RecyclerView.Adapter{
        private Context mContext;
        private List<String> datas=new ArrayList<>();
        private final LayoutInflater inflater;

        public MyAdapter(Context context, List<String> list) {
            mContext=context;
            datas.clear();
            datas.addAll(list);
            inflater = LayoutInflater.from(mContext);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.grad_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder holder1 = (ViewHolder) holder;
            String str = datas.get(position);
            holder1.tv.setText(str);
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
