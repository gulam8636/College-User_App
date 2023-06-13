package com.example.myapp20.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapp20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView Nursery,LKG,UKG,StdOne,StdTwo,StdThree,StdFour,StdFive,StdSix,StdSeven,StdEight,StdNine,StdTen;
    private LinearLayout NurseryNoData,LKGNoData,UKGNoData,StdOneNoData,StdTwoNoData,StdThreeNoData,StdFourNoData,StdFiveNoData,StdSixNoData,StdSevenNoData,
            StdEightNoData,StdNineNoData,StdTenNoData;
    private TeacherAdapter adapter;
    private List<TeacherData> list1,list2,list3,list4,list5,list6,list7,list8,list9,list10,list11,list12,list13;
    private DatabaseReference reference,dBRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);
        //DataFinding
        Nursery = view.findViewById(R.id.Nursery);
        NurseryNoData = view.findViewById(R.id.NurseryNoData);
        LKG = view.findViewById(R.id.LKG);
        LKGNoData = view.findViewById(R.id.LKGnoData);
        UKG = view.findViewById(R.id.UKG);
        UKGNoData = view.findViewById(R.id.UKGnoData);
        StdOne = view.findViewById(R.id.StdOneDepartment);
        StdOneNoData = view.findViewById(R.id.StdOneNoData);
        StdTwo = view.findViewById(R.id.StdTwoDepartment);
        StdTwoNoData = view.findViewById(R.id.StdTwoNoData);
        StdThree = view.findViewById(R.id.StdThreeDepartment);
        StdThreeNoData = view.findViewById(R.id.StdThreeNoData);
        StdFour = view.findViewById(R.id.StdFourDepartment);
        StdFourNoData = view.findViewById(R.id.StdFourNoData);
        StdFive = view.findViewById(R.id.StdFiveDepartment);
        StdFiveNoData = view.findViewById(R.id.StdFiveNoData);
        StdSix =view.findViewById(R.id.StdSixDepartment);
        StdSixNoData = view.findViewById(R.id.StdSixNoData);
        StdSeven = view.findViewById(R.id.StdSeven);
        StdSevenNoData = view.findViewById(R.id.StdSevenNoData);
        StdEight = view.findViewById(R.id.StdEightDepartment);
        StdEightNoData = view.findViewById(R.id.StdEightNoData);
        StdNine = view.findViewById(R.id.StdNineDepartment);
        StdNineNoData = view.findViewById(R.id.StdNineNoData);
        StdTen = view.findViewById(R.id.StdTenDepartment);
        StdTenNoData = view.findViewById(R.id.StdTenNoData);
        reference = FirebaseDatabase.getInstance().getReference().child("Faculty");

        // Calling Methos
        Nursery();
        LKG();
        UKG();
        StdOne();
        StdTwo();
        StdThree();
        StdFour();
        StdFive();
        StdSix(); StdSeven();StdEight();StdNine();StdTen();
        
        return view;
    }

    private void Nursery() {
        dBRef = reference.child("Nursery");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(!snapshot.exists()){
                    NurseryNoData.setVisibility(View.VISIBLE);
                    Nursery.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        data.setUniqueKey(snapshot1.getKey());
                        list1.add(data);
                    }
                if (list1!=null && snapshot.exists()) {
                    Nursery.setHasFixedSize(true);
                    Nursery.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext(), "Nursery");
                    Nursery.setAdapter(adapter);
                    NurseryNoData.setVisibility(View.GONE);
                    Nursery.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void LKG() {
        dBRef = reference.child("LKG");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(!snapshot.exists()){
                    LKGNoData.setVisibility(View.VISIBLE);
                    LKG.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        //("LKGDTATA", data.getUniqueKey());
                        list2.add(data);
                    }
                if (list2!=null && snapshot.exists()) {
                    LKG.setHasFixedSize(true);
                    LKG.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext(), "LKG");
                    LKG.setAdapter(adapter);
                    LKGNoData.setVisibility(View.GONE);
                    LKG.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void UKG() {
        dBRef = reference.child("UKG");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(!snapshot.exists()){
                    UKGNoData.setVisibility(View.VISIBLE);
                    UKG.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list3.add(data);
                    }
                if (list3!=null && snapshot.exists()) {
                    UKG.setHasFixedSize(true);
                    UKG.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext(), "UKG");
                    UKG.setAdapter(adapter);
                    UKGNoData.setVisibility(View.GONE);
                    UKG.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdOne() {
        dBRef = reference.child("I");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdOneNoData.setVisibility(View.VISIBLE);
                    StdOne.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list4.add(data);
                    }
                if (list4!=null && snapshot.exists()) {
                    StdOne.setHasFixedSize(true);
                    StdOne.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext(), "I");
                    StdOne.setAdapter(adapter);
                    StdOneNoData.setVisibility(View.GONE);
                    StdOne.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdTwo() {
        dBRef = reference.child("II");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdTwoNoData.setVisibility(View.VISIBLE);
                    StdTwo.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list5.add(data);
                    }
                if (list5!=null && snapshot.exists()) {
                    StdTwo.setHasFixedSize(true);
                    StdTwo.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext(), "II");
                    StdTwo.setAdapter(adapter);
                    StdTwoNoData.setVisibility(View.GONE);
                    StdTwo.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdThree() {
        dBRef = reference.child("III");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdThreeNoData.setVisibility(View.VISIBLE);
                    StdThree.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list6.add(data);
                    }
                if (list6!=null && snapshot.exists()) {
                    StdThree.setHasFixedSize(true);
                    StdThree.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6, getContext(), "III");
                    StdThree.setAdapter(adapter);
                    StdThreeNoData.setVisibility(View.GONE);
                    StdThree.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdFour() {
        dBRef = reference.child("IV");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list7 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdFourNoData.setVisibility(View.VISIBLE);
                    StdFour.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list7.add(data);
                    }
                if (list7!=null && snapshot.exists()) {
                    StdFour.setHasFixedSize(true);
                    StdFour.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7, getContext(), "IV");
                    StdFour.setAdapter(adapter);
                    StdFourNoData.setVisibility(View.GONE);
                    StdFour.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdFive() {
        dBRef = reference.child("V");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list8 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdFiveNoData.setVisibility(View.VISIBLE);
                    StdFive.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list8.add(data);
                    }
                if (list8!=null && snapshot.exists()) {
                    StdFive.setHasFixedSize(true);
                    StdFive.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list8, getContext(), "V");
                    StdFive.setAdapter(adapter);
                    StdFiveNoData.setVisibility(View.GONE);
                    StdFive.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdSix() {
        dBRef = reference.child("VI");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list9 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdSixNoData.setVisibility(View.VISIBLE);
                    StdSix.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list9.add(data);
                    }
                if (list9!=null && snapshot.exists()) {
                    StdSix.setHasFixedSize(true);
                    StdSix.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list9, getContext(), "VI");
                    StdSix.setAdapter(adapter);
                    StdSixNoData.setVisibility(View.GONE);
                    StdSix.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdSeven() {
        dBRef = reference.child("VII");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list10 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdSevenNoData.setVisibility(View.VISIBLE);
                    StdSeven.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list10.add(data);
                    }
                if (list10!=null && snapshot.exists()) {
                    StdSeven.setHasFixedSize(true);
                    StdSeven.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list10, getContext(), "VII");
                    StdSeven.setAdapter(adapter);
                    StdSevenNoData.setVisibility(View.GONE);
                    Nursery.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdEight() {
        dBRef = reference.child("VIII");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list11 = new ArrayList<>();
                if (!snapshot.exists()) {
                    StdEightNoData.setVisibility(View.VISIBLE);
                    StdEight.setVisibility(View.GONE);
                } else
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list11.add(data);
                    }
                if (list11!=null && snapshot.exists()) {
                    StdEight.setHasFixedSize(true);
                    StdEight.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list11, getContext(), "VIII");
                    StdEight.setAdapter(adapter);
                    StdEightNoData.setVisibility(View.GONE);
                    StdEight.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdNine() {
        dBRef = reference.child("IX");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list12 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdNineNoData.setVisibility(View.VISIBLE);
                    StdNine.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list12.add(data);
                    }
                if (list12!=null && snapshot.exists()) {
                    StdNine.setHasFixedSize(true);
                    StdNine.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list12, getContext(), "IX");
                    StdNine.setAdapter(adapter);
                    StdNineNoData.setVisibility(View.GONE);
                    StdNine.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void StdTen() {
        dBRef = reference.child("X");
        dBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list13 = new ArrayList<>();
                if(!snapshot.exists()){
                    StdTenNoData.setVisibility(View.VISIBLE);
                    StdTen.setVisibility(View.GONE);
                }else
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        //(snapshot1.getKey());
                        list13.add(data);
                    }
                if (list13!=null && snapshot.exists()) {
                    StdTen.setHasFixedSize(true);
                    StdTen.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list13, getContext(), "X");
                    StdTen.setAdapter(adapter);
                    StdTenNoData.setVisibility(View.GONE);
                    StdTen.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}