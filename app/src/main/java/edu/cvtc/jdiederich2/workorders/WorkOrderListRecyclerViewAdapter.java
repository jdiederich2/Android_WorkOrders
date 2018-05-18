package edu.cvtc.jdiederich2.workorders;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jdiederich2 on 5/17/2018.
 */

public class WorkOrderListRecyclerViewAdapter extends RecyclerView.Adapter<WorkOrderListRecyclerViewAdapter.WorkOrderListViewHolder> {

    private List<WorkOrderModel> workOrderModelList;
    private View.OnClickListener onClickListener;
    public LayoutInflater mInflater;

    public WorkOrderListRecyclerViewAdapter(List<WorkOrderModel> workOrderModelList, View.OnClickListener onClickListener) {
        this.workOrderModelList = workOrderModelList;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public WorkOrderListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = mInflater.inflate(R.layout.recyclerview_workorders, parent, false);
//        return new WorkOrderListViewHolder(itemView);
        return new WorkOrderListViewHolder(LayoutInflater.from(parent.getContext()).inflate( R.layout.recyclerview_workorders, parent, false));
    }


    public void insertWorkOrder(List<WorkOrderModel> workOrderModelList) {
        this.workOrderModelList = workOrderModelList;
        notifyDataSetChanged();
    }


    static class WorkOrderListViewHolder extends RecyclerView.ViewHolder {
        private final TextView mFirstName;
        private final TextView mLastName;
        private final TextView mPhone;
        private final TextView mAddress;
        private final TextView mCity;
        private final TextView mAccountNumber;
        private final TextView mInstallDate;

        private WorkOrderListViewHolder(View itemView) {
            super(itemView);
            mFirstName = (TextView) itemView.findViewById( R.id.editText_FirstName);
            mLastName = (TextView) itemView.findViewById( R.id.editText_LastName);
            mPhone = (TextView) itemView.findViewById( R.id.editText_Phone);
            mAddress = (TextView) itemView.findViewById( R.id.editText_Address);
            mCity = (TextView) itemView.findViewById(R.id.editText_City);
            mAccountNumber = (TextView) itemView.findViewById( R.id.editText_AcctNumber);
            mInstallDate = (TextView) itemView.findViewById( R.id.editText_InstallDate);

        }
    }








    @Override
    public void onBindViewHolder(@NonNull WorkOrderListViewHolder holder, int position) {
        if(null != holder) {
            WorkOrderModel workOrderModel = workOrderModelList.get(position);
            holder.mFirstName.setText( workOrderModel.getCsFirstName());
            holder.mLastName.setText( workOrderModel.getCsLastName());
            holder.mPhone.setText( workOrderModel.getCsPhoneNumber());
            holder.mAddress.setText( workOrderModel.getCsAddress());
            holder.mCity.setText( workOrderModel.getCsCity());
            holder.mAccountNumber.setText( workOrderModel.getCsAccountNum());
            holder.mInstallDate.setText( workOrderModel.getCsInstallDate());
            holder.itemView.setTag(workOrderModel);
            holder.itemView.setOnClickListener( onClickListener );

        } else {
            holder.mFirstName.setText("No First Name");
            holder.mLastName.setText("No Last Name");
            holder.mPhone.setText("No Phone Number");
            holder.mAddress.setText("No Address");
            holder.mCity.setText("No City");
            holder.mAccountNumber.setText("No Account Number");
            holder.mInstallDate.setText("No Install Date");
        }
    }

    @Override
    public int getItemCount() {
        return workOrderModelList.size();
    }


    // TODO: Verify if needed
    private LiveData<List<WorkOrderModel>> mWorkOrders;

    WorkOrderListRecyclerViewAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }
}

