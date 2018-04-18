package com.lmm.taker.common.widget.recycler;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface AdapterCallback<Data> {
    void update(Data data,RecyclerAdapter.ViewHolder<Data> holder);
}
