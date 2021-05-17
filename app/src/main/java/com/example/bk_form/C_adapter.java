package com.example.bk_form;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class C_adapter extends RecyclerView.Adapter<C_adapter.ViewHolder> {

    private List<Bean> list;
    private Context context;
    private Dao dao;
    private LayoutInflater layoutInflater;
    private View view;
    private ViewHolder viewHolder;

    public C_adapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
        dao = new Dao(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.item_list, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Bean bean = list.get(position);

        holder.f_name_resp.setText(bean.getName());
        holder.l_name_resp.setText(bean.getLast_name());
        holder.e_email_resp.setText(bean.getEmail());
        holder.p_password_resp.setText(bean.getPassword());
        holder.c_cpf_resp.setText(bean.getCpf());
        holder.cn_cnpj_resp.setText(bean.getCnpj());
        holder.a_address_resp.setText(bean.getAddress());

        holder.go_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.del(bean.getId());
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView f_name_resp, l_name_resp, e_email_resp, p_password_resp, c_cpf_resp, cn_cnpj_resp, a_address_resp, f_id_resp;
        private Button go_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            f_name_resp = itemView.findViewById(R.id.f_name_resp);
            l_name_resp = itemView.findViewById(R.id.l_name_resp);
            e_email_resp = itemView.findViewById(R.id.e_email_resp);
            p_password_resp = itemView.findViewById(R.id.p_password_resp);
            c_cpf_resp = itemView.findViewById(R.id.c_cpf_resp);
            cn_cnpj_resp = itemView.findViewById(R.id.cn_cnpj_resp);
            a_address_resp = itemView.findViewById(R.id.a_address_resp);
            go_delete = itemView.findViewById(R.id.go_delete);
        }
    }
}