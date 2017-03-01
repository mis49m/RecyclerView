package tr.com.mis49m.recyclerview;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Contact> contacts;

    // Provide a reference to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder{

        // each data item is just a string in this case
        public TextView tvName, tvPhone, tvInitials;
        public CheckBox checkBox;
        public View circle;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name);
            tvPhone = (TextView) itemView.findViewById(R.id.phone);
            checkBox = (CheckBox) itemView.findViewById(R.id.check);
            circle = (View) itemView.findViewById(R.id.circle);
            tvInitials = (TextView) itemView.findViewById(R.id.initials);

        }
    }

    public MyAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder viewHolder, final int position) {
        final Contact contact = contacts.get(position);
        viewHolder.tvName.setText(contact.name);
        viewHolder.tvPhone.setText(contact.phone);
        viewHolder.tvInitials.setText(contact.name.substring(0,1).toUpperCase());
        viewHolder.checkBox.setChecked(contact.isChecked);
        GradientDrawable background = (GradientDrawable) viewHolder.circle.getBackground();
        background.setColor(Color.parseColor(contact.color));

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                contact.isChecked = b;
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


}
