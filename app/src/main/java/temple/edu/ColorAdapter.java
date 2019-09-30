package temple.edu;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ColorAdapter extends BaseAdapter {
    ArrayList<CustomColor> customColors;
    Context context;
    String select;
    public ColorAdapter(Context context, ArrayList<CustomColor> customColors,String select) {
        this.customColors = customColors;
        this.context = context;
        this.select = select;
    }

    @Override
    public int getCount() {
        return customColors.size();
    }

    @Override
    public Object getItem(int i) {
        return customColors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_color, viewGroup,false);
            holder.llRoot =  view.findViewById(R.id.ll_root);
            holder.tvName =  view.findViewById(R.id.tv_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        CustomColor customColor = customColors.get(i);
        if (select.equals(customColor.getName())){
            holder.llRoot.setBackgroundColor(Color.parseColor("#ffffff"));
        }else{
            holder.llRoot.setBackgroundColor(Color.parseColor(customColor.getColor()));
        }

        holder.tvName.setText(customColor.getName());
        return view;
    }

    public void changeSelect(String selectColor) {
        this.select = selectColor;
        notifyDataSetChanged();
    }

    private class ViewHolder{
        LinearLayout llRoot;
        TextView tvName;
    }
}
