package edu.cvtc.jdiederich2.workorders.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.cvtc.jdiederich2.workorders.Models.WorkOrderModel;
import edu.cvtc.jdiederich2.workorders.R;

public class WorkOrderListRecyclerViewAdapter extends RecyclerView.Adapter<WorkOrderListRecyclerViewAdapter.WorkOrderListViewHolder> {

    class WorkOrderListViewHolder extends RecyclerView.ViewHolder {
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


    // Cached copy of work orders list
    private List<WorkOrderModel> mCachedWorkOrderList;

    public WorkOrderListRecyclerViewAdapter(List<WorkOrderModel> workOrderModelList) {
        this.mCachedWorkOrderList = workOrderModelList;
    }


    @NonNull
    @Override
    public WorkOrderListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WorkOrderListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_workorderlist_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WorkOrderListRecyclerViewAdapter.WorkOrderListViewHolder holder, int position) {

        if(null != mCachedWorkOrderList) {
            WorkOrderModel currentWorkOrder = mCachedWorkOrderList.get(position);
            holder.mFirstName.setText( currentWorkOrder.getCsFirstName());
            holder.mLastName.setText( currentWorkOrder.getCsLastName());
            holder.mPhone.setText( currentWorkOrder.getCsPhoneNumber());
            holder.mAddress.setText( currentWorkOrder.getCsAddress());
            holder.mCity.setText( currentWorkOrder.getCsCity());
            holder.mAccountNumber.setText( currentWorkOrder.getCsAccountNum());
            holder.mInstallDate.setText( currentWorkOrder.getCsInstallDate());
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

    public void setWorkOrderList(List<WorkOrderModel> workOrderList) {
        mCachedWorkOrderList = workOrderList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(null != mCachedWorkOrderList)
            return mCachedWorkOrderList.size();
        return 0;
    }
}