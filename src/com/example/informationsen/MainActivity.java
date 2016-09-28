package com.example.informationsen;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.MsgAdapter;
import com.example.entity.Msg;

import android.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity{
	MsgAdapter adapter;
	private ListView  msgListView;
	private EditText inputText;
	private Button send;
	private List<Msg> msgList = new ArrayList<Msg>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		initMsg();
		adapter = new MsgAdapter(this, R.layout.msg_item, msgList);
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView = (ListView) findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				String content = inputText.getText().toString();
				if(!"".equals(content)){
					Msg msg = new Msg(content, Msg.TYPE_SEND);
					msgList.add(msg);
					adapter.notifyDataSetChanged();
					msgListView.setSelection(msgList.size());
					inputText.setText("");
				}
			}
		});
	}
	private void initMsg() {
		// TODO 自动生成的方法存根
		Msg msg1 = new Msg("Hello", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("Hello,Who is that",Msg.TYPE_SEND);
		msgList.add(msg2);
		Msg msg3 = new Msg("This is Tom", Msg.TYPE_RECEIVED);
		msgList.add(msg3);
	}
}
