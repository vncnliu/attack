
var StockRow = React.createClass({
    render: function () {
        return (
            <tr>
                <td>{this.props.report.custom}</td>
                <td>{this.props.report.belongUser}</td>
                <td>{this.props.report.balance}</td>
                <td>{this.props.report.recharge}</td>
                <td>{this.props.report.countTime}</td>
            </tr>
        );
    }
});

var StockTable = React.createClass({
    render: function () {
        var items = [];
        var report = {custom: "GM", belongUser: "VNCN", balance: 38.87, recharge: 38.87, countTime: 38.87};
        items.push(<StockRow key={report.custom} report={report} />);
        return (
            <div className="row">
            <table className="table-hover">
                <thead>
                    <tr>
                        <th>客户名称</th>
                        <th>所属用户</th>
                        <th>余额</th>
                        <th>充值</th>
                        <th>统计时间</th>
                    </tr>
                </thead>
                <tbody>
                    {items}
                </tbody>
            </table>
            </div>
        );
    }
});

var HomePage = React.createClass({
    getInitialState: function() {
        var stocks = {};
        return {stocks: stocks};
    },
    render: function () {
        return (
            <div>
                <StockTable />
                <div className="row">
                    <div className="alert alert-warning" role="alert">All stock values are fake and changes are simulated. Do not trade based on the above data.</div>
                </div>
            </div>
        );
    }
});

React.render(<HomePage />, document.getElementById('main'));