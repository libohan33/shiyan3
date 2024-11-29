package com.example.shiyan3;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionMode extends AppCompatActivity {

    private ListView listView;
    private String[] items = {"One", "Two", "Three", "Four", "Five"};
    private boolean mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new MultiChoiceModeListener());
    }

    private class MultiChoiceModeListener implements ListView.MultiChoiceModeListener {
        @Override
        public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
            if(item.getItemId()==R.id.menu_delete){
                deleteSelectedItems();
                mode.finish();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(android.view.ActionMode mode) {
            mActionMode = false;
            listView.clearChoices();
        }

        @Override
        public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked) {
            int count = listView.getCheckedItemCount();
            mode.setTitle(count + " selected");
            mActionMode = true;
        }
    }


    private void deleteSelectedItems() {
        ArrayList<String> selectedItems = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if (listView.isItemChecked(i)) {
                selectedItems.add(items[i]);
            }
        }
        // Remove selected items from the list
        for (String item : selectedItems) {
            items = removeItemFromArray(items, item);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ActionMode.this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }

    private String[] removeItemFromArray(String[] array, String item) {
        List<String> tempList = new ArrayList<>(Arrays.asList(array));
        tempList.remove(item);
        return tempList.toArray(new String[0]);
    }
}