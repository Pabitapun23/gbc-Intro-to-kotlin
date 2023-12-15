package com.jk.share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.jk.share.databinding.ActivityHomeBinding
import com.jk.share.models.Expense
import com.jk.share.models.User
import com.pp.share.repositories.ExpenseRepository
import java.io.Serializable

class HomeActivity : AppCompatActivity() , OnExpenseClickListener{

    private val TAG = this.toString()
    private lateinit var binding: ActivityHomeBinding
    private lateinit var expenseRepository : ExpenseRepository

    private lateinit var expenseAdapter: ExpenseAdapter
    private lateinit var expenseArrayList: ArrayList<Expense>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        expenseArrayList = ArrayList()
        expenseAdapter = ExpenseAdapter(this, expenseArrayList, this)
        binding.rvExpenses.layoutManager = LinearLayoutManager(this)
        binding.rvExpenses.addItemDecoration(
            DividerItemDecoration(
                this.applicationContext,
                DividerItemDecoration.VERTICAL
            )
        )

        this.binding.rvExpenses.adapter = expenseAdapter

        expenseRepository = ExpenseRepository(applicationContext)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_add_expense -> {
                Log.d(TAG, "onOptionsItemSelected: Add Expense option is selected")

                val mainIntent = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(mainIntent)

                return true
            }
            R.id.action_profile -> {
                Log.d(TAG, "onOptionsItemSelected: Profile option is selected")

                val mainIntent = Intent(this@HomeActivity, ProfileActivity::class.java)
//                mainIntent.putExtra("EXTRA_USER_INFO", User as Serializable)
                startActivity(mainIntent)
                return true
            }
            R.id.action_sign_out -> {
                Log.d(TAG, "onOptionsItemSelected: Sign Out option is selected")
                FirebaseAuth.getInstance().signOut()
                this@HomeActivity.finish()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onResume() {
        super.onResume()

        expenseRepository.retrieveAllExpenses()




        expenseRepository.allExpenses.observe(this, androidx.lifecycle.Observer { expenseList ->
            Log.d(TAG, "expenseList--sdfgsdfgdsfgsdfgsdfgdfgsdf--${expenseList}")

            if(expenseList != null){
//                clear the existing list to avoid duplicate records
                expenseArrayList.clear()
                expenseArrayList.addAll(expenseList)
                expenseAdapter.notifyDataSetChanged()


            }
        })


    }

    override fun onExpenseSelected(expense: Expense) {

        val mainIntent = Intent(this, ExpenseDetailsActivity::class.java)
        mainIntent.putExtra("EXTRA_EXPENSE", expense as Serializable)
//        Log.d("CHECK", "$expenseArrayList")
        startActivity(mainIntent)
    }
}








package com.jk.share

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.get
import com.jk.share.databinding.ActivityExpenseDetailsBinding
import com.jk.share.models.Expense
import com.pp.share.repositories.ExpenseRepository
import kotlin.math.roundToInt

class ExpenseDetailsActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityExpenseDetailsBinding
    private lateinit var expenseRepository: ExpenseRepository
    val tipPercentage = intArrayOf(0, 5, 10, 20)
    var tipAmount = 0.0
    var checkAmount = 0.0
    var tax = 0f
    var selectedTipPer = 1
    private lateinit var expenseAdapter: ExpenseAdapter
    private lateinit var expenseArrayList: ArrayList<Expense>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_expense_details)

        binding = ActivityExpenseDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener(this)
        binding.btnDelete.setOnClickListener(this)

        expenseRepository = ExpenseRepository(applicationContext)

        val expense = intent.getSerializableExtra("EXTRA_EXPENSE") as? Expense
        if (expense != null) {
            // Use the 'expense' object to populate the details in the ExpenseDetailsActivity UI

            Log.d("TEST", "$expense")
            binding.etCheckAmount.setText(expense.checkAmount.toString())
            binding.etPersons.setText(expense.persons.toString())
            if (expense.donationAmount != null) {
                if (expense.donationAmount == 5.0) {
                    binding.rbYes.setChecked(true)
                } else {
                    binding.rbNo.setChecked(true)
                }
            }


            //TODO: Spinner data display
            val tipAdapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.array_tip)
            )

            binding.spTipPercentage.adapter = tipAdapter

            // get selected items
//            for tip percentage
            val tip = expense.tipPercentage.toInt()
            binding.spTipPercentage.setSelection(tipPercentage.indexOf(tip))


            binding.spTipPercentage.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {

                    Log.d("TAG", "onItemSelected: User wants to leave ${tipPercentage[position]} % of tip")
                    Log.d("TAG", "onItemSelected: User selection : ${resources.getStringArray(R.array.array_tip).get(position)}")
                    selectedTipPer = tipPercentage[position]
                    tipAmount = ((checkAmount + tax) * selectedTipPer / 100).toDouble()

//
//                    Log.d("TAG", "${tipPercentage[1]}")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    Log.d("TAG", "onNothingSelected: User has not made any selection. Set the default percentage to 0%")
                }
            }


        }

    }


    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_update -> {
                    Log.d("TAG", "onClick: btnUpdate performed")
                    updateCalculation()
                    finish()
                }
                R.id.btn_delete -> {
                    Log.d("TAG", "onClick: btnDelete performed")
                    deleteExpense()
                    finish()
                }
            }
        }
    }

    private fun updateCalculation() {
        val expense = intent.getSerializableExtra("EXTRA_EXPENSE") as? Expense
        if (expense != null) {
//            this.expenseRepository.updateExpense(expense)

            var id = expense.id
            var checkAmount = expense.checkAmount
            var persons = expense.persons
            var donationAmount = expense.donationAmount.toInt()

            // checkAmount
            if (checkAmount.toString().isEmpty()) {
                binding.etCheckAmount.setError(resources.getString(R.string.error_check_amount))
            } else {
                checkAmount = (binding.etCheckAmount.text.toString().toFloatOrNull() ?: 0.0f).toDouble()
            }

            //person
            if(persons.toString().isEmpty()) {
                binding.etPersons.setError(resources.getString(R.string.error_persons))
            } else {
                persons = binding.etPersons.text.toString().toInt()
            }

            // tax
            tax = (checkAmount * 0.13).toFloat();

            val selectedIndex = binding.spTipPercentage.selectedItemPosition
            selectedTipPer = tipPercentage[selectedIndex];
            tipAmount = ((checkAmount + tax) * selectedTipPer / 100).toDouble();

            when(binding.rgDonation.checkedRadioButtonId){
                R.id.rdb_yes -> donationAmount = 5
                R.id.rdb_no -> donationAmount = 0
            }

            var billAmount = ((checkAmount + tax) + tipAmount + donationAmount).toDouble()
            var amountPerPerson = billAmount / persons

            //save expense to database
            val expenseToUpdate = Expense(
                id = id,
                checkAmount = checkAmount.toDouble(),
                persons = persons,
                tipPercentage = selectedTipPer.toDouble(),
                donationAmount = donationAmount.toDouble())

            Log.d("TAG", "Checking $expenseToUpdate")

            this.expenseRepository.updateExpense(expenseToUpdate)

//            Log.d("TAG", "Checking ${this.expenseRepository.updateExpense(expenseToUpdate)}")


        }

    }

    private fun deleteExpense() {
        val expense = intent.getSerializableExtra("EXTRA_EXPENSE") as? Expense
        if (expense != null) {

            this.expenseRepository.deleteExpense(expense)

        }
    }


}





package com.pp.share.repositories

import android.content.Context
import android.content.SharedPreferences
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.firestore
import com.jk.share.models.Expense
import java.lang.Exception

// Controller
class ExpenseRepository(
    private val context : Context
) {
    private val TAG = this.toString()
    // get an instance of firestore database
    private val db = Firebase.firestore

    // here, the field name must be same as the class variable
    private val COLLECTION_EXPENSES = "Expenses"
    private val COLLECTION_USERS = "Users"
    private val FIELD_CHECK_AMOUNT = "checkAmount"
    private val FIELD_PERSONS = "persons"
    private val FIELD_TIP_PERCENTAGE = "tipPercentage"
    private val FIELD_DONATION_AMOUNT = "donationAmount"
    private val FIELD_ID = "id"

    private var loggedInUserEmail = ""
    private lateinit var sharedPrefs : SharedPreferences

    // expecting all docs from our collection, that's why we use List<> here.
    var allExpenses : MutableLiveData<List<Expense>> = MutableLiveData<List<Expense>>()

    init {
        sharedPrefs = context.getSharedPreferences("com.pp.share", Context.MODE_PRIVATE)

        if (sharedPrefs.contains("USER_EMAIL")) {
            loggedInUserEmail = sharedPrefs.getString("USER_EMAIL", "NA").toString()
        }
    }

    fun addExpenseToDB(newExpense : Expense) {

        if (loggedInUserEmail.isNotEmpty()) {
            try {
                // MutableMap<String, Any> - key, value
                val data : MutableMap<String, Any> = HashMap()

                data[FIELD_ID] = newExpense.id
                data[FIELD_CHECK_AMOUNT] = newExpense.checkAmount
                data[FIELD_PERSONS] = newExpense.persons
                data[FIELD_DONATION_AMOUNT] = newExpense.donationAmount
                data[FIELD_TIP_PERCENTAGE] = newExpense.tipPercentage

                // for adding document to nested collection
                db.collection(COLLECTION_USERS)
                    .document(loggedInUserEmail)
                    .collection(COLLECTION_EXPENSES)
                    .add(data)
                    .addOnSuccessListener { docRef ->
                        Log.d(TAG, "addExpenseToDB: Document successfully added with ID : ${docRef.id} ")
                    }
                    .addOnFailureListener { docRef ->
                        Log.d(TAG, "addExpenseToDB: Exception ocurred while adding a document")
                    }


                // .add() - only to create new doc with randomly generated id
                // .set() - create and update doc. Checks if the doc is already exist, if no then create a new one
                // For adding document to root level collection
//            db
//                .collection(COLLECTION_EXPENSES)
//                .add(data)
//                .addOnSuccessListener { docRef ->
//                    Log.d(TAG, "addExpenseToDB: Document successfully added with ID : ${docRef.id} ")
//                }
//                .addOnFailureListener { docRef ->
//                    Log.d(TAG, "addExpenseToDB: Exception ocurred while adding a document ")
//                }
            } catch (ex : java.lang.Exception) {
                Log.d(TAG, "addExpenseToDB: Couldn't perform insert on Expenses collection due to exception $ex")
            }
        } else {
            Log.d(TAG, "addExpenseToDB: Cannot create expense without user's email address. You must create the account first.")
        }

    }

    fun retrieveAllExpenses() {

        if (loggedInUserEmail.isNotEmpty()) {
            try {
                // Snapshot - result of our query
                db.collection(COLLECTION_USERS)
                    .document(loggedInUserEmail)
                    .collection(COLLECTION_EXPENSES)
                    .addSnapshotListener(EventListener { result, error ->
                        if (error != null) {
                            Log.d(TAG, "retrieveAllExpenses: Listening to Expenses collection failed due to error : $error")
                            return@EventListener
                        }

                        if (result != null) {
                            Log.d(TAG, "retrieveAllExpenses: Number of documents retrieved: ${result.size()}")

                            val tempList: MutableList<Expense> = ArrayList<Expense>()

                            for (docChanges in result.documentChanges) {

                                val currentDocument : Expense = docChanges.document.toObject(Expense::class.java)
                                Log.d(TAG, "retrieveAllExpenses: currentDocument : $currentDocument ")

                                when(docChanges.type) {
                                    DocumentChange.Type.ADDED -> {
                                        // do necessary changes to your local list of objects
                                        tempList.add(currentDocument)
                                    }
                                    DocumentChange.Type.MODIFIED -> {
                                        tempList.add(currentDocument)
                                    }
                                    DocumentChange.Type.REMOVED -> {

                                    }
                                }
                            } // for

                            Log.d(TAG, "retrieveAllExpenses: tempList : $tempList")
                            // replace the value in allExpenses
                            allExpenses.postValue(tempList)

                        } else {
                            Log.d(TAG, "retrieveAllExpenses: No data in the result after retrieving")
                        }
                    })

            } catch (ex : java.lang.Exception) {
                Log.d(TAG, "retrieveAllExpenses: Unable to retrieve all expenses : $ex")
            }
        } else {
            Log.d(TAG, "retrieveAllExpenses: Cannot retrieve expenses without user's email address. You must sign in firt.")
        }

    }

    fun filterExpenses(amount : Double, persons : Int){
        if (loggedInUserEmail.isNotEmpty()) {
            try{
                db.collection(COLLECTION_USERS)
                    .document(loggedInUserEmail)
                    .collection(COLLECTION_EXPENSES)
                    .whereGreaterThan(FIELD_CHECK_AMOUNT, amount)
                    .whereLessThan(FIELD_PERSONS, persons)
                    .addSnapshotListener(EventListener { result, error ->
                        //check for result or errors and update UI accordingly
                        if (error != null){
                            Log.e(TAG,
                                "filterExpenses: Listening to Expenses collection failed due to error : $error", )
                            return@EventListener
                        }

                        if (result != null){
                            Log.d(TAG, "filterExpenses: Number of documents retrieved : ${result.size()}")

                            val tempList : MutableList<Expense> = ArrayList<Expense>()

                            for (docChanges in result.documentChanges){

                                val currentDocument : Expense = docChanges.document.toObject(Expense::class.java)
                                Log.d(TAG, "filterExpenses: currentDocument : $currentDocument")

                                //do necessary changes to your local list of objects
                                tempList.add(currentDocument)
                            }//for
                            Log.d(TAG, "filterExpenses: tempList : $tempList")
                            //replace the value in allExpenses
                            allExpenses.postValue(tempList)

                        }else{
                            Log.d(TAG, "filterExpenses: No data in the result after retrieving")
                        }
                    })
            }
            catch (ex : java.lang.Exception){
                Log.e(TAG, "filterExpenses: Unable to filter expenses : $ex", )
            }
        }
    }


    fun updateExpense(expenseToUpdate : Expense) {
        if (loggedInUserEmail.isNotEmpty()) {
            val data: MutableMap<String, Any> = HashMap();

            data[FIELD_CHECK_AMOUNT] = expenseToUpdate.checkAmount;
            data[FIELD_PERSONS] = expenseToUpdate.persons
            data[FIELD_DONATION_AMOUNT] = expenseToUpdate.donationAmount
            data[FIELD_TIP_PERCENTAGE] = expenseToUpdate.tipPercentage

            Log.d("TAG", "let's see ${expenseToUpdate.id}")


            try{
                db.collection(COLLECTION_USERS)
                    .document(loggedInUserEmail)
                    .collection(COLLECTION_EXPENSES)
//                    .document(expenseToUpdate.id)
//                    .update(data)
                    .whereEqualTo("id", expenseToUpdate.id)
                    .get()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Handle success
                            Log.d("TAG", "success")
                        } else {
                            // Handle failure
                            val exception = task.exception
                            if (exception != null) {
                                Log.e("TAG", "Firestore Exception: $exception")
                            }
                        }
                    }
                    .addOnSuccessListener { docRef ->
                        Log.d(TAG, "updateExpense: Document updated successfully : $docRef")

                        if (!docRef.isEmpty) {
                            val document = docRef.documents[0]
                            // Update the document
                            document.reference.update(data)
                                .addOnSuccessListener {
                                    // Update data successfully
                                    Log.d(TAG, "updateExpense: Updated successfully")
                                }
                                .addOnFailureListener { e ->
                                    // Handle failure
                                    Log.d(TAG,"Error deleting document: $e")
                                }


                        } else {
                            Log.d(TAG,"Document not found")
                        }

                    }
                    .addOnFailureListener { ex ->
                        Log.e(TAG, "updateExpense: Failed to update document : $ex", )
                    }
            }
            catch (ex : Exception){
                Log.e(TAG, "updateExpense: Unable to update expense due to exception : $ex", )
            }
        }


    }


    fun deleteExpense(expenseToDelete : Expense){
        try {
            db.collection(COLLECTION_USERS)
                .document(loggedInUserEmail)
                .collection(COLLECTION_EXPENSES)
//                .document(expenseToDelete.id)
//                .delete()
                .whereEqualTo("id", expenseToDelete.id)
                .get()
                .addOnSuccessListener { docRef ->
                    Log.d(TAG, "deleteExpense: Document deleted successfully : $docRef")

                    if (!docRef.isEmpty) {
                        val document = docRef.documents[0]
                        // Delete the document
                        document.reference.delete()
                            .addOnSuccessListener {
                                // Deletion successful
                                this.retrieveAllExpenses()
                            }
                            .addOnFailureListener { e ->
                                // Handle failure
                                println("Error deleting document: $e")
                            }
                    } else {
                        println("Document not found")
                    }
                }.addOnFailureListener { ex ->
                    Log.e(TAG, "deleteExpense: Failed to delete document : $ex")
                }

        } catch (ex: Exception) {
            Log.e(TAG, "deleteExpense: Unable to delete expense due to exception: $ex")
        }
    }
}