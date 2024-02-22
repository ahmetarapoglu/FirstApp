package com.FirstApp.FirstApp.scheduler;
import com.FirstApp.FirstApp.entity.Purchase;
import com.FirstApp.FirstApp.entity.Refund;
import com.FirstApp.FirstApp.model.ReportData;
import com.FirstApp.FirstApp.service.EmailService;
import com.FirstApp.FirstApp.service.PurchaseService;
import com.FirstApp.FirstApp.service.RefundService;
import com.FirstApp.FirstApp.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduledJob {

    private final EmailService emailService;
    private final PurchaseService purchaseService;
    private  final RefundService refundService;

    @Value("${spring.mail.recipient}")
    private String recipient;

    private ReportData getData(){

        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        int year = yesterday.getYear();
        int month = yesterday.getMonthValue();
        int day = yesterday.getDayOfMonth();
        LocalDateTime start = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime end = LocalDateTime.of(year, month, day, 23, 59);

        List<Purchase> getPurchasesByDate = purchaseService.getPurchasesByDate(start , end);
        List<Refund> getRefundsByDate = refundService.getRefundsByDate(start , end);

        ReportData reportData = new ReportData();
        reportData.setPurchases(getPurchasesByDate);
        reportData.setRefunds(getRefundsByDate);

        return reportData;
    }

    private String generateHtmlReport(ReportData reportData){

        List<Purchase> purchases = reportData.getPurchases();
        List<Refund> refunds = reportData.getRefunds();
        StringBuilder tableContent = new StringBuilder();

        tableContent.append("<h2>Purchase :</h2>");
        tableContent.append("<table border='1'>");
        tableContent.append("<tr>");
        tableContent.append("<th>ID</th>");
        tableContent.append("<th>CustomerName</th>");
        tableContent.append("<th>ProductName</th>");
        tableContent.append("<th>Amount</th>");
        tableContent.append("<th>CreatedDate</th>");
        tableContent.append("</tr>");

        for (Purchase purchase : purchases) {
            tableContent.append("<tr>");
                tableContent.append("<td>").append(purchase.getId()).append("</td>");
                tableContent.append("<td>").append(purchase.getCustomer().getName()).append("</td>");
                tableContent.append("<td>").append(purchase.getProduct().getName()).append("</td>");
                tableContent.append("<td>").append(purchase.getAmount()).append("</td>");
            tableContent.append("<td>").append(DateUtil.getDateTime(purchase.getCreated())).append("</td>");
            tableContent.append("</tr>");
        }

        tableContent.append("</table>");

        tableContent.append("<h2>Refund :</h2>");
        tableContent.append("<table border='1'>");
        tableContent.append("<tr>");
        tableContent.append("<th>ID</th>");
        tableContent.append("<th>CustomerName</th>");
        tableContent.append("<th>ProductName</th>");
        tableContent.append("<th>Amount</th>");
        tableContent.append("<th>CreatedDate</th>");
        tableContent.append("</tr>");

        for (Refund refund : refunds) {
            tableContent.append("<tr>");
                tableContent.append("<td>").append(refund.getId()).append("</td>");
                tableContent.append("<td>").append(refund.getCustomer().getName()).append("</td>");
                tableContent.append("<td>").append(refund.getProduct().getName()).append("</td>");
                tableContent.append("<td>").append(refund.getAmount()).append("</td>");
                tableContent.append("<td>").append(DateUtil.getDateTime(refund.getCreated())).append("</td>");
            tableContent.append("</tr>");
        }

        tableContent.append("</table>");

        return tableContent.toString();

    }

    //@Scheduled(fixedRate = 1000)
    @Scheduled(cron = "0 0 1 * * ?")
    public void executeReportGeneration() {

        ReportData reportData = getData();

        String htmlContent = generateHtmlReport(reportData);

//        emailService.sendEmail(recipient,"Report",htmlContent);
//        System.out.println("Report sent at 01:00 AM Successfully!.");
    }

}
