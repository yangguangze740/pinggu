$(document).ready(function(){
    $('.dataTables-example').DataTable({
        pageLength: 50,
        responsive: true,
        dom: '<"html5buttons"B>lTfgitp',
        oLanguage : {
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sInfo": "当前第 _START_ 至 _END_ 项记录 /共 _TOTAL_ 项数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "sZeroRecords": "没有检索到数据",
            "sSearch": "查询:",
            "sEmptyTable" : "表中数据为空",
            "sLoadingRecords" : "载入中...",
            "sProcessing" : "处理中...",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "前一页",
                "sNext": "后一页",
                "sLast": "末页"
            }
        },
        buttons: [
            {
                extend: 'copy',
                text: '复制',
                sCharSet: 'utf-8'
            },
            // {extend: 'csv'},
            {
                extend: 'excelHtml5',
                text: '表格',
                title: 'ExampleFile',
                sCharSet: 'utf-8'
            },
            // {
            //     extend: 'pdf',
            //     title: 'ExampleFile',
            //     sCharSet: 'utf-8'
            // },

            {
                extend: 'pdf',
                text: '打印',
                customize: function (win){
                    $(win.document.body).addClass('white-bg');
                    $(win.document.body).css('font-size', '10px');

                    $(win.document.body).find('table')
                        .addClass('compact')
                        .css('font-size', 'inherit');
                }
            }
        ]

    });
});