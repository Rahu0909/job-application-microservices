package com.project.reviewappservice.review.messaging;

import com.project.reviewappservice.review.dto.ReviewMessage;
import com.project.reviewappservice.review.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(Review review){
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(review.getId());
        reviewMessage.setTitle(review.getTitle());
        reviewMessage.setDescription(review.getDescription());
        reviewMessage.setRating(review.getRating());
        reviewMessage.setCompanyId(review.getCompanyId());
        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);
    }
}
