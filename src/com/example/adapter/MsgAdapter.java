package com.example.adapter;

import java.util.List;

import com.example.entity.Msg;
import com.example.informationsen.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg>{

	int resourceId;
	public MsgAdapter(Context context, int resource, List<Msg> objects) {
		super(context, resource, objects);
		resourceId = resource;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		View view;
		ViewHolder viewHolder;
		Msg msg = getItem(position);
		if(convertView==null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
			viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
			viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
			viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);
			view.setTag(viewHolder);
		}else{
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		if(msg.getType()==Msg.TYPE_RECEIVED){
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);
			viewHolder.leftMsg.setText(msg.getContent());
		}else if(msg.getType()==Msg.TYPE_SEND){
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightMsg.setText(msg.getContent());
		}
		return view;
	}
	class ViewHolder{
		LinearLayout leftLayout;
		LinearLayout rightLayout;
		TextView leftMsg;
		TextView rightMsg;
	}
}
