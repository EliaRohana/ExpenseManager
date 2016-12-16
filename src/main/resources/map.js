db.monthly_reports.aggregate([
   {
   $match : {year: 2016}
   },
   {
   $project: {
       costTotal: { $sum: "expenses.cost"},
     }
   }
])



db.monthly_reports.aggregate(
   [
   {
   $match : {id: '584afe0ae81a9f1268378454'}
   },

     {

       $group:
        {
           _id: null,
           total: { $sum: "expenses.cost"},
         }
     }
   ]
)

db.monthly_reports.aggregate( [
    { $unwind: "$expenseList" },
    { $group: {
        _id: '$_id',
        sum: { $sum: 'expenses.cost' }
    }
    }
] );